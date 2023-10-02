package com.friedNote.friedNote_backend.domain.inventory.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.response.InventoryResponse;
import com.friedNote.friedNote_backend.domain.inventory.application.mapper.InventoryMapper;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@UseCase
@RequiredArgsConstructor
@Transactional
public class InventoryGetUseCase {

    private final InventoryQueryService inventoryQueryService;

    public List<InventoryResponse.InventoryInfoResponse> getInventoryList(Long userId) {
        List<Inventory> inventoryList = inventoryQueryService.findByUserId(userId);
        List<InventoryResponse.InventoryInfoResponse> inventoryInfoResponseList
                = inventoryList.stream()
                .map(inventory -> {
                    InventoryResponse.InventoryInfoResponse inventoryInfoResponse
                            = InventoryMapper.mapToInventoryInfo(inventory);
                    return inventoryInfoResponse;
                }).collect(toList());
        return inventoryInfoResponseList;
    }
}
