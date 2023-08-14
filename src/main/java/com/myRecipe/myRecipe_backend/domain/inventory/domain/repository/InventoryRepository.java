package com.myRecipe.myRecipe_backend.domain.inventory.domain.repository;

import com.myRecipe.myRecipe_backend.domain.inventory.domain.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
