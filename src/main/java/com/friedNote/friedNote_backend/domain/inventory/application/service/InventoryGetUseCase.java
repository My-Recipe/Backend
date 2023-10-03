package com.friedNote.friedNote_backend.domain.inventory.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.response.InventoryResponse;
import com.friedNote.friedNote_backend.domain.inventory.application.mapper.InventoryMapper;
import com.friedNote.friedNote_backend.domain.inventory.domain.entity.Inventory;
import com.friedNote.friedNote_backend.domain.inventory.domain.service.InventoryQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

@UseCase
@RequiredArgsConstructor
@Transactional
@Slf4j
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
    public List<InventoryResponse.InventoryInfoResponse> getInventoryListByExpirationDate(Long userId) {
        List<Inventory> inventoryList = inventoryQueryService.findByUserId(userId);
        List<InventoryResponse.InventoryInfoResponse> inventoryInfoResponseList = new ArrayList<>();
        inventoryList.forEach(inventory -> {
            LocalDate expirationDate = inventory.getExpirationDate();
            LocalDate nowDate = LocalDate.now();
            if(ChronoUnit.DAYS.between(nowDate, expirationDate) <= 7
                    && ChronoUnit.DAYS.between(nowDate,expirationDate) >= 0){
                inventoryInfoResponseList.add(InventoryMapper.mapToInventoryInfo(inventory));
            }
        });
        return inventoryInfoResponseList;
    }
    //태그 뿌려주기
    public List<InventoryResponse.InventoryTagInfoResponse> getTagInfo(Long userId) {
        List<Inventory> inventoryList = inventoryQueryService.findByUserId(userId);
        if(inventoryList.isEmpty()){
            return null;
        }
        //유통기한 임박한 상위 6개 꺼내기
        List<InventoryResponse.InventoryTagInfoResponse> inventoryTagInfoResponseList = inventoryList.stream()
                .filter(inventory -> ChronoUnit.DAYS.between(LocalDate.now(), inventory.getExpirationDate()) >= 0)
                .sorted(Comparator.comparing(inventory ->
                        ChronoUnit.DAYS.between(LocalDate.now(), inventory.getExpirationDate())))
                .map(inventory -> {
                    InventoryResponse.InventoryTagInfoResponse inventoryTagInfoResponse
                            = InventoryMapper.mapToInventoryTagInfo(inventory);
                    return inventoryTagInfoResponse;
                })
                .limit(6)
                .collect(toList());

        return inventoryTagInfoResponseList;
    }

}
