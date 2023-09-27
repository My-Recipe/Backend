package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.common.util.UserUtils;
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


@UseCase
@RequiredArgsConstructor
@Transactional
public class RecipeListGetUseCase {

    private final RecipeQueryService recipeQueryService;
    private final CookingProcessQueryService cookingProcessQueryService;
    private final IngredientGroupQueryService ingredientGroupQueryService;
    private final BookmarkQueryService bookmarkQueryService;
    private final UserUtils userUtils;

    private String imageUrl = "";
    private String fullDescription = "";
    boolean isBookmarked;

    /**
     * 레시피북 -> 내가 작성한 레시피만 보기
     */
    public List<RecipeResponse.RecipeListResponse> getMyRecipeList(Long userId) {

        List<Recipe> recipeList = recipeQueryService.findRecipeByUserId(userId);

        List<RecipeResponse.RecipeListResponse> recipeListResponses = recipeList.stream().map(recipe -> {

            imageUrl = "";
            fullDescription = "";

            Long recipeId = recipe.getId();
            List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipe(recipe);
            List<String> cookingProcessImageUrlList = getCookingProcessImageUrlList(cookingProcessList);
            isBookmarked = true;

            return getRecipeListResponse(recipeId, recipe, cookingProcessList, cookingProcessImageUrlList, isBookmarked);
        }).collect(Collectors.toList());
        return recipeListResponses;
    }

    /**
     * 레시피북 -> 내가 북마크한 레시피 + 내가 작성한 레시피 보기
     */
    public List<RecipeResponse.RecipeListResponse> getMyAllRecipeList(Long userId) {

        //합치고 정렬하고 dto로 변환
        List<Recipe> recipeByUserId = recipeQueryService.findRecipeByUserId(userId);
        List<Bookmark> bookmarkByUserId = bookmarkQueryService.findByUserId(userId);

        List<Object> recipeAndBookmark = new ArrayList<>();
        recipeAndBookmark.addAll(recipeByUserId);
        recipeAndBookmark.addAll(bookmarkByUserId);

        //시간 순으로 정렬
        sortByTimeOrder(recipeAndBookmark);

        //Object -> recipeResponseDto로 변환
        List<RecipeResponse.RecipeListResponse> recipeListResponses = recipeAndBookmark.stream().map(Object -> {
            imageUrl = "";
            fullDescription = "";

            if(Object instanceof Recipe){
                Recipe recipe = (Recipe) Object;
                Long recipeId = recipe.getId();
                List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipe(recipe);
                List<String> cookingProcessImageUrlList = getCookingProcessImageUrlList(cookingProcessList);
                isBookmarked = true;

                return getRecipeListResponse(recipeId, recipe, cookingProcessList, cookingProcessImageUrlList, isBookmarked);
            }
            else{
                Bookmark bookmark = (Bookmark) Object;
                Long recipeId = bookmark.getRecipe().getId();
                Recipe recipe = recipeQueryService.findRecipeById(recipeId);
                List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipe(recipe);
                List<String> cookingProcessImageUrlList = getCookingProcessImageUrlList(cookingProcessList);
                isBookmarked = true;

                return getRecipeListResponse(recipeId, recipe, cookingProcessList, cookingProcessImageUrlList, isBookmarked);
            }
        }).collect(Collectors.toList());
        return recipeListResponses;
    }

    /**
     * 홈화면 -> 레시피 최신순으로
     */
    public List<RecipeResponse.RecipeListResponse> getHomeRecipeList() {

        List<Recipe> recipeList = recipeQueryService.findAll();

        List<RecipeResponse.RecipeListResponse> recipeListResponses = recipeList.stream().map(recipe -> {

            imageUrl = "";
            fullDescription = "";

            Long recipeId = recipe.getId();
            List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipe(recipe);
            List<String> cookingProcessImageUrlList = getCookingProcessImageUrlList(cookingProcessList);
            isBookmarked = checkBookmark(recipeId);
            return getRecipeListResponse(recipeId, recipe, cookingProcessList, cookingProcessImageUrlList, isBookmarked);
        }).collect(Collectors.toList());
        return recipeListResponses;
    }

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
            if(!imageUrl1.equals("")){
                cookingProcessImageUrlList.add(imageUrl1);
            }
        });
        return cookingProcessImageUrlList;
    }

    private RecipeResponse.RecipeListResponse getRecipeListResponse(Long recipeId, Recipe recipe,
                                                                    List<CookingProcess> cookingProcessList,
                                                                    List<String> cookingProcessImageUrlList, boolean isBookmarked) {
        if (cookingProcessImageUrlList.isEmpty()) {
            addIngredientDescription(recipeId);
            addCookingProcessDescription(recipeId);
        } else {
            setImageUrl(cookingProcessList, cookingProcessImageUrlList);
        }
        return RecipeMapper.mapToRecipeAllResponse(recipe, imageUrl, fullDescription, isBookmarked);
    }

    private boolean checkBookmark(Long recipeId) {
        Long userId = userUtils.getUser().getId();
        boolean myRecipe = recipeQueryService.existsByUserIdAndId(userId, recipeId);
        boolean bookmark = bookmarkQueryService.existsByUserIdAndRecipeId(userId, recipeId);
        if(myRecipe || bookmark) {
            return true;
        } else {
            return false;
        }
    }

    private static void sortByTimeOrder(List<Object> recipeAndBookmark) {
        recipeAndBookmark.sort((o1, o2) -> {
            if (o1 instanceof Recipe && o2 instanceof Recipe) {
                return ((Recipe) o2).getCreatedDate().compareTo(((Recipe) o1).getCreatedDate());
            } else if (o1 instanceof Bookmark && o2 instanceof Bookmark) {
                return ((Bookmark) o2).getCreatedDate().compareTo(((Bookmark) o1).getCreatedDate());
            } else if (o1 instanceof Recipe && o2 instanceof Bookmark) {
                return ((Bookmark) o2).getCreatedDate().compareTo(((Recipe) o1).getCreatedDate());
            } else {
                return ((Recipe) o2).getCreatedDate().compareTo(((Bookmark) o1).getCreatedDate());
            }
        });
    }
}
