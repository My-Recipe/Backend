package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.common.util.UserUtils;
import com.friedNote.friedNote_backend.domain.bookmark.domain.service.BookmarkQueryService;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.dto.response.CookingProcessResponse;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.mapper.CookingProcessMapper;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.service.CookingProcessQueryService;
import com.friedNote.friedNote_backend.domain.ingredient.application.dto.response.IngredientResponse;
import com.friedNote.friedNote_backend.domain.ingredient.application.mapper.IngredientMapper;
import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import com.friedNote.friedNote_backend.domain.ingredient.domain.service.IngredientQueryService;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.dto.response.IngredientGroupResponse;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.mapper.IngredientGroupMapper;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.service.IngredientGroupQueryService;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.response.InventoryResponse;
import com.friedNote.friedNote_backend.domain.inventory.application.service.InventoryGetUseCase;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.response.RecipeResponse;
import com.friedNote.friedNote_backend.domain.recipe.application.mapper.RecipeMapper;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RecipeRecommendGetUseCase {
    private final RecipeQueryService recipeQueryService;
    private final IngredientGroupQueryService ingredientGroupQueryService;
    private final IngredientQueryService ingredientQueryService;
    private final CookingProcessQueryService cookingProcessQueryService;
    private final BookmarkQueryService bookmarkQueryService;
    private final InventoryGetUseCase inventoryGetUseCase;

    private final UserUtils userUtils;
    private String imageUrl;
    private String fullDescription;
    boolean isBookmarked;

    public List<RecipeResponse.RecipeListResponse> getRecommendRecipeListByShortIngredient() {
        List<InventoryResponse.InventoryInfoResponse> inventoryInfoResponseList = inventoryGetUseCase.getInventoryListByExpirationDate();
        List<String> shortExpirationIngredients = inventoryInfoResponseList.stream().map(inventoryInfoResponse -> {
            String name = inventoryInfoResponse.getName();
            return name;
        }).collect(toList());
        List<Recipe> recipeList = new ArrayList<>();
        shortExpirationIngredients.forEach(ingredientName -> {
            List<Ingredient> ingredientList = ingredientQueryService.findByIngredientName(ingredientName);
            List<Recipe> recipes = ingredientList.stream().map(ingredient -> {
                Long ingredientGroupId = ingredient.getIngredientGroup().getId();
                IngredientGroup ingredientGroup = ingredientGroupQueryService.findIngredientGroupById(ingredientGroupId);
                Long recipeId = ingredientGroup.getRecipe().getId();
                Recipe recipe = recipeQueryService.findRecipeById(recipeId);
                return recipe;
            }).distinct().collect(toList());
            recipeList.addAll(recipes);
        });
        List<RecipeResponse.RecipeListResponse> recipeListResponseList = getRecipeListResponses(recipeList);
        return recipeListResponseList;
    }

    private List<RecipeResponse.RecipeListResponse> getRecipeListResponses(List<Recipe> recipeList) {
        List<RecipeResponse.RecipeListResponse> recipeListResponseList = recipeList.stream().map(recipe -> {
            imageUrl = "";
            fullDescription = "";

            Long recipeId = recipe.getId();
            List<CookingProcess> cookingProcessList = cookingProcessQueryService.findByRecipe(recipe);
            List<String> cookingProcessImageUrlList = getCookingProcessImageUrlList(cookingProcessList);
            isBookmarked = checkBookmark(recipeId);
            return getRecipeListResponse(recipeId, recipe, cookingProcessList, cookingProcessImageUrlList, isBookmarked);
        }).collect(toList());
        return recipeListResponseList;
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
        return RecipeMapper.mapToRecipeListResponse(recipe, imageUrl, fullDescription, isBookmarked);
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

    private List<CookingProcessResponse.CookingProcessInfoResponse> getCookingProcessInfoResponses(Long recipeId) {
        List<CookingProcess> cookingProcessList = cookingProcessQueryService.findCookingProcessByRecipeIdOrderByCookingProcessSequenceAsc(recipeId);
        List<CookingProcessResponse.CookingProcessInfoResponse> cookingProcessInfoResponseList = cookingProcessList.stream().map(cookingProcess -> {
            CookingProcessResponse.CookingProcessInfoResponse cookingProcessInfoResponse = CookingProcessMapper.mapToCookingProcessInfoResponse(cookingProcess);
            return cookingProcessInfoResponse;
        }).collect(toList());
        return cookingProcessInfoResponseList;
    }
    private List<IngredientGroupResponse.IngredientGroupInfoResponse> getIngredientGroupInfoResponses(Long recipeId) {
        List<IngredientGroup> ingredientGroupList = ingredientGroupQueryService.findByRecipeId(recipeId);
        List<IngredientGroupResponse.IngredientGroupInfoResponse> ingredientGroupInfoResponseList = ingredientGroupList.stream().map(ingredientGroup -> {
            List<Ingredient> ingredientList = ingredientGroup.getIngredientList();
            List<IngredientResponse.IngredientInfoResponse> ingredientInfoResponseList = ingredientList.stream().map(ingredient -> {
                IngredientResponse.IngredientInfoResponse ingredientInfoResponse = IngredientMapper.mapToIngredientInfoResponse(ingredient);
                return ingredientInfoResponse;
            }).collect(toList());

            IngredientGroupResponse.IngredientGroupInfoResponse ingredientGroupInfoResponse
                    = IngredientGroupMapper.mapToIngredientGroupInfoResponse(ingredientGroup, ingredientInfoResponseList);
            return ingredientGroupInfoResponse;
        }).collect(toList());
        return ingredientGroupInfoResponseList;
    }
}
