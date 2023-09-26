package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.common.util.UserUtils;
import com.friedNote.friedNote_backend.domain.bookmark.domain.entity.Bookmark;
import com.friedNote.friedNote_backend.domain.bookmark.domain.service.BookmarkQueryService;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.service.CookingProcessQueryService;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.response.RecipeResponse;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RecipeMainGetUseCase {

    private final BookmarkQueryService bookmarkQueryService;
    private final RecipeQueryService recipeQueryService;
    private final CookingProcessQueryService cookingProcessQueryService;
    private final UserUtils userUtils;

    private String description = "";
    private boolean bookmark;

    //최근 한달(30일)동안 북마크 많이 된 순서대로
    public List<RecipeResponse.RecipeMainResponse> getRecommendRecipeList() {

        List<Long> recipeIdList = getBookmarkedRecipeIdListDuringOneMonth();
        List<Map.Entry<Long, Long>> recipeIdAndCountEntries = getRecipeIdAndCountEntries(recipeIdList);
        List<RecipeResponse.RecipeMainResponse> recipeMainResponseList = getRecipeMainResponses(recipeIdAndCountEntries);
        return recipeMainResponseList;
    }

    private List<RecipeResponse.RecipeMainResponse> getRecipeMainResponses(List<Map.Entry<Long, Long>> recipeIdAndCountEntries) {
        List<RecipeResponse.RecipeMainResponse> recipeMainResponseList = recipeIdAndCountEntries.stream()
                .map(entry -> {
                    Long recipeId = entry.getKey();
                    Recipe recipe = recipeQueryService.findRecipeById(recipeId);
                    addCookingProcessDescription(recipeId);
                    checkBookmark(recipeId);
                    Long totalRecipeCount = getTotalRecipeCount(recipe);

                    return RecipeResponse.RecipeMainResponse.builder()
                            .recipeId(recipeId)
                            .recipeName(recipe.getRecipeName())
                            .userName(recipe.getUser().getName())
                            .description(description)
                            .bookmark(bookmark)
                            .totalRecipeCount(totalRecipeCount.toString())
                        .build();
               }).collect(Collectors.toList());

        return recipeMainResponseList;
    }

    private void checkBookmark(Long recipeId) {
        Long userId = userUtils.getUser().getId();
        boolean isBookmark = bookmarkQueryService.existsByUserIdAndRecipeId(userId, recipeId);
        boolean myRecipe = recipeQueryService.existsByUserIdAndId(userId, recipeId);
        if(isBookmark || myRecipe){
            bookmark = true;
        } else{
            bookmark = false;
        }
    }

    //레시피북에 있는 총 레시피 갯수 -> 레시피 + 북마크
    private Long getTotalRecipeCount(Recipe recipe) {
        Long recipeCount = recipeQueryService.countRecipeByUserId(recipe.getUser().getId());
        Long bookmarkCount = bookmarkQueryService.countByUserId(recipe.getUser().getId());
        Long totalRecipeCount = recipeCount + bookmarkCount;
        return totalRecipeCount;
    }

    private List<Map.Entry<Long, Long>> getRecipeIdAndCountEntries(List<Long> recipeIdList) {

        Map<Long, Long> map = recipeIdList.stream()
                .collect(Collectors.toMap(
                        (recipeId -> recipeId), recipeId -> bookmarkQueryService.countByRecipeId(recipeId)));

        //value 기준으로 내림차순 정렬
        List<Map.Entry<Long, Long>> recipeIdAndCountEntries = new ArrayList<>(map.entrySet());
        recipeIdAndCountEntries.sort(new Comparator<Map.Entry<Long, Long>>() {
            @Override
            public int compare(Map.Entry<Long, Long> o1, Map.Entry<Long, Long> o2) {
                return (int) (o2.getValue() - o1.getValue());
            }
        });

        return recipeIdAndCountEntries;
    }

    private List<Long> getBookmarkedRecipeIdListDuringOneMonth() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime ago = now.minusDays(30);
        List<Bookmark> bookmarkList = bookmarkQueryService.findByCreatedDateBetween(ago, now);

        List<Long> recipeIdList = bookmarkList.stream().map(bookmark -> {
            Long recipeId = bookmark.getRecipe().getId();
            return recipeId;
        }).distinct().collect(Collectors.toList());

        return recipeIdList;
    }

    private void addCookingProcessDescription(Long recipeId) {

        List<CookingProcess> cookingProcessListAsc = cookingProcessQueryService
                .findCookingProcessByRecipeIdOrderByCookingProcessSequenceAsc(recipeId);

        cookingProcessListAsc.forEach(cookingProcess -> {
            String cookingDescription = cookingProcess.getDescription();
            description = description.concat(cookingDescription).concat(" ");
        });
    }
}
