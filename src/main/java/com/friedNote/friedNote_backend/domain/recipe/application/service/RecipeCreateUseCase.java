package com.friedNote.friedNote_backend.domain.recipe.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.cookingProcess.application.mapper.CookingProcessMapper;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.cookingProcess.domain.service.CookingProcessSaveService;
import com.friedNote.friedNote_backend.domain.ingredient.application.mapper.IngredientMapper;
import com.friedNote.friedNote_backend.domain.ingredient.domain.entity.Ingredient;
import com.friedNote.friedNote_backend.domain.ingredient.domain.service.IngredientSaveService;
import com.friedNote.friedNote_backend.domain.ingredientGroup.application.mapper.IngredientGroupMapper;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.entity.IngredientGroup;
import com.friedNote.friedNote_backend.domain.ingredientGroup.domain.service.IngredientGroupSaveService;
import com.friedNote.friedNote_backend.domain.recipe.application.dto.request.RecipeRequest;
import com.friedNote.friedNote_backend.domain.recipe.application.mapper.RecipeMapper;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import com.friedNote.friedNote_backend.domain.recipe.domain.service.RecipeSaveService;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.entity.RecipeBook;
import com.friedNote.friedNote_backend.domain.recipeBook.domain.service.RecipeBookQueryService;
import com.friedNote.friedNote_backend.domain.s3.S3UploadService;
import com.friedNote.friedNote_backend.domain.user.domain.entity.User;
import com.friedNote.friedNote_backend.domain.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RecipeCreateUseCase {

    private final RecipeSaveService recipeSaveService;
    private final RecipeBookQueryService recipeBookQueryService;
    private final UserQueryService userQueryService;
    private final CookingProcessSaveService cookingProcessSaveService;

    private final IngredientGroupSaveService ingredientGroupSaveService;
    private final IngredientSaveService ingredientSaveService;
    private final S3UploadService s3UploadService;

    public void createRecipe(RecipeRequest.RecipeCreateRequest recipeCreateRequest) {
        Long recipeBookId = recipeCreateRequest.getRecipeBookId();
        RecipeBook recipeBook = recipeBookQueryService.findById(recipeBookId);

        Long userId = recipeCreateRequest.getUserId();
        User user = userQueryService.findById(userId);

        Recipe recipe = RecipeMapper.mapToRecipe(recipeCreateRequest, recipeBook, user);
        recipeSaveService.saveRecipe(recipe);

        recipeCreateRequest.getCookingProcessCreateRequestList().forEach(cookingProcessCreateRequest -> {
            if(cookingProcessCreateRequest.getImage() != null) {
                    MultipartFile image = cookingProcessCreateRequest.getImage();
                    String uploadUrl = s3UploadService.upload(image);
                    CookingProcess cookingProcess = CookingProcessMapper.mapToCookingProcess(cookingProcessCreateRequest, recipe, uploadUrl);
                    cookingProcessSaveService.saveCookingProcess(cookingProcess);
                }
            else{
                    CookingProcess cookingProcess = CookingProcessMapper.mapToCookingProcess(cookingProcessCreateRequest, recipe, "");
                    cookingProcessSaveService.saveCookingProcess(cookingProcess);
                }
            }
        );

        recipeCreateRequest.getIngredientGroupCreateRequestList().forEach(ingredientGroupCreateRequest -> {
                    //재료그룹저장
                    IngredientGroup ingredientGroup = IngredientGroupMapper.mapToIngredientGroup(ingredientGroupCreateRequest, recipe);
                    ingredientGroupSaveService.saveIngredientGroup(ingredientGroup);

                    //재료저장
                    ingredientGroupCreateRequest.getIngredientList().forEach(ingredientCreateRequest -> {
                        Ingredient ingredient = IngredientMapper.mapToIngredient(ingredientCreateRequest, ingredientGroup);
                        ingredientSaveService.saveIngredient(ingredient);
                    }
                    );
                }
        );
    }
}

