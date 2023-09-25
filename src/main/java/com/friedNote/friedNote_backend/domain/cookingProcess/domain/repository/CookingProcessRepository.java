package com.friedNote.friedNote_backend.domain.cookingProcess.domain.repository;

import com.friedNote.friedNote_backend.domain.cookingProcess.domain.entity.CookingProcess;
import com.friedNote.friedNote_backend.domain.recipe.domain.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CookingProcessRepository extends JpaRepository<CookingProcess, Long> {

    List<CookingProcess> findByRecipe(Recipe recipe);

    List<CookingProcess> findCookingProcessByRecipeIdOrderByCookingProcessSequenceAsc(Long recipeId);

    List<CookingProcess> findByRecipeId(Long recipeId);
    //Querydsl 사용
    //boolean findRepresentativeImageStatusByImageUrl(String imageUrl);
}
