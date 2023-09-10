package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.bookmark.application.dto.response.BookmarkResponse;
import com.friedNote.friedNote_backend.domain.bookmark.domain.entity.Bookmark;
import com.friedNote.friedNote_backend.domain.bookmark.domain.service.BookmarkQueryService;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.service.CookingProcessQueryService;
import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.service.IngredientGroupQueryService;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.response.RecipeResponse;
import com.friedNote.friedNote_backend.domain.recipe.application.mapper.RecipeMapper;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.friedNote.friedNote_backend.domain.bookmark.application.mapper.BookmarkMapper.mapToBookmarkInfoResponse;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RecipeGetUseCase {

    private final RecipeQueryService recipeQueryService;
    private final CookingProcessQueryService cookingProcessQueryService;
    private final IngredientGroupQueryService ingredientGroupQueryService;

    private final BookmarkQueryService bookmarkQueryService;

    private String imageUrl = "";
    private String fullDescription = "";

    public List<RecipeResponse.RecipeListResponse> getMyRecipeList(Long userId) {

        List<Recipe> recipeList = recipeQueryService.findRecipeByUserId(userId);

        return recipeList.stream().map(recipe -> {

            imageUrl = "";
            fullDescription = "";

            Long recipeId = recipe.getId();
            List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipe(recipe);
            List<String> cookingProcessImageUrlList = getCookingProcessImageUrlList(cookingProcessList);

            if (cookingProcessImageUrlList.isEmpty()) {
                addIngredientDescription(recipeId);
                addCookingProcessDescription(recipeId);
            } else {
                setImageUrl(cookingProcessList, cookingProcessImageUrlList);
            }
            return RecipeMapper.mapToRecipeAllResponse(recipe, imageUrl, fullDescription, true);
        }).collect(Collectors.toList());
    }

//    public List<RecipeResponse.RecipeListResponse> getMyAllRecipeList(Long userId) {
//        //레시피 테이블: userId로 쿼리 날려서 리스트 받아온다.
//        //북마크 테이블: userId로 쿼리 날려서 리스트 받아온다.
//        //둘을 합치고 정렬 - 사용자 정의 정렬
//        return null;
//    }

    private void setImageUrl(List<CookingProcess> cookingProcessList, List<String> cookingProcessImageUrlList) {
        imageUrl = imageUrl.concat(cookingProcessImageUrlList.get(0));
        cookingProcessList.forEach(cookingProcess -> {
            if(cookingProcess.getCookingProcessImage().isRepresentativeImageStatus()) {
                imageUrl = cookingProcess.getCookingProcessImage().getImageUrl();
            }
        });
    }

    private void addCookingProcessDescription(Long recipeId) {
        List<CookingProcess> cookingProcessListAsc = cookingProcessQueryService
                .findCookingProcessByRecipeIdOrderByCookingProcessSequenceAsc(recipeId);

        cookingProcessListAsc.forEach(cookingProcess -> {
            String cookingDescription = cookingProcess.getDescription();
            fullDescription = fullDescription.concat(cookingDescription).concat(" ");
        });
    }

    private void addIngredientDescription(Long recipeId) {
        List<IngredientGroup> ingredientGroupList = ingredientGroupQueryService.findIngredientGroupByRecipeId(recipeId);
        ingredientGroupList.forEach(ingredientGroup -> {
            System.out.println("ingredientGroup.getGroupName() = " + ingredientGroup.getGroupName());
            String groupName = ingredientGroup.getGroupName();
            fullDescription = fullDescription.concat(groupName).concat(": ");
            List<Ingredient> ingredientList = ingredientGroup.getIngredientList();
            int size = ingredientList.size();
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    fullDescription = fullDescription.concat(ingredientList.get(i).getIngredientName()).concat(" ");
                } else {
                    fullDescription = fullDescription.concat(ingredientList.get(i).getIngredientName()).concat(", ");
                }
            }
        });
    }

    private static List<String> getCookingProcessImageUrlList(List<CookingProcess> cookingProcessList) {
        List<String> cookingProcessImageUrlList = new ArrayList<>();

        cookingProcessList.forEach(cookingProcess -> {
            String imageUrl1 = cookingProcess.getCookingProcessImage().getImageUrl();
            if(imageUrl1!=null && !imageUrl1.equals("")){
                cookingProcessImageUrlList.add(imageUrl1);
            }
        });
        return cookingProcessImageUrlList;
    }

    //레시피 모두 보기
    public List<RecipeResponse.RecipeListResponse> getMyAllRecipeList(Long userId) {

        imageUrl = "";
        fullDescription = "";

        //레시피 테이블: userId로 쿼리 날려서 리스트 받아온다.
        List<Recipe> recipeListByUserId = recipeQueryService.findRecipeByUserId(userId);
        List<RecipeResponse.RecipeListResponse> recipeResponse1 = recipeListByUserId.stream().map(recipe -> {
            imageUrl = "";
            fullDescription = "";

            Long recipeId = recipe.getId();
            List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipe(recipe);
            List<String> cookingProcessImageUrlList = getCookingProcessImageUrlList(cookingProcessList);

            if (cookingProcessImageUrlList!=null && cookingProcessImageUrlList.isEmpty()) {
                addIngredientDescription(recipeId);
                addCookingProcessDescription(recipeId);
            } else {
                setImageUrl(cookingProcessList, cookingProcessImageUrlList);
            }
            return RecipeMapper.mapToRecipeAllResponse(recipe, imageUrl, fullDescription, true);
        }).collect(Collectors.toList());

        //북마크 테이블: userId로 쿼리 날려서 리스트 받아온다. -> 북마크 되어있는지 어떻게 확인?
        List<Bookmark> bookmarkListByUserId = bookmarkQueryService.findByUserId(userId);

        List<BookmarkResponse.BookmarkInfoResponse> bookmarkInfoResponses =
                bookmarkListByUserId.stream()
                        .map(bookmark -> mapToBookmarkInfoResponse(bookmark))
                        .collect(Collectors.toList());

        //boolean == true 인 것들만 list 저장
        List<BookmarkResponse.BookmarkInfoResponse> isBookmarktrue = bookmarkInfoResponses.stream()
                .filter(bookmarkInfoResponse -> bookmarkInfoResponse.isBookMark() == true)
                .collect(Collectors.toList());

        List<RecipeResponse.RecipeListResponse> recipeResponse2 = isBookmarktrue.stream().map(bookmarkInfoResponse -> {
            imageUrl = "";
            fullDescription = "";

            Long recipeId = bookmarkInfoResponse.getRecipeId();
            Recipe recipe = recipeQueryService.findById(recipeId);
            List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipe(recipe);
            List<String> cookingProcessImageUrlList = getCookingProcessImageUrlList(cookingProcessList);

            if (cookingProcessImageUrlList.isEmpty()) {
                addIngredientDescription(recipeId);
                addCookingProcessDescription(recipeId);
            } else {
                setImageUrl(cookingProcessList, cookingProcessImageUrlList);
            }
            return RecipeMapper.mapToRecipeAllResponse(recipe, imageUrl, fullDescription, true);
        }).collect(Collectors.toList());

        //둘을 합치고 정렬 - 사용자 정의 정렬
        List<RecipeResponse.RecipeListResponse> recipeResponse = new ArrayList<>();
        recipeResponse.addAll(recipeResponse1);
        recipeResponse.addAll(recipeResponse2);
        return recipeResponse;
    }
}
