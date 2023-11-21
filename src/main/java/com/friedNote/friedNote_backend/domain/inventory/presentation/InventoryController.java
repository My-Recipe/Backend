package com.friedNote.friedNote_backend.domain.inventory.presentation;

import com.friedNote.friedNote_backend.common.exception.dto.ErrorResponse;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.request.InventoryRequest;
import com.friedNote.friedNote_backend.domain.inventory.application.dto.response.InventoryResponse;
import com.friedNote.friedNote_backend.domain.inventory.application.service.InventoryCreateUseCase;
import com.friedNote.friedNote_backend.domain.inventory.application.service.InventoryGetUseCase;
import com.friedNote.friedNote_backend.domain.inventory.application.service.InventoryUpdateUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryCreateUseCase inventoryCreateUseCase;
    private final InventoryUpdateUseCase inventoryUpdateUseCase;
    private final InventoryGetUseCase inventoryGetUseCase;

    @Operation(summary = "냉장고 속 재료 생성", tags = {"InventoryController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "재료 생성 성공"),
            @ApiResponse(responseCode = "404", description = "재료 생성 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/inventory")
    public void createInventory(@RequestBody InventoryRequest.InventoryCreateRequest inventoryCreateRequest) {
        inventoryCreateUseCase.createInventory(inventoryCreateRequest);
    }

    @Operation(summary = "냉장고 속 재료 리스트 조회", tags = {"InventoryController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "재료 리스트 조회 성공"),
            @ApiResponse(responseCode = "404", description = "재료 리스트 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/inventory")
    public List<InventoryResponse.InventoryInfoResponse> getInventoryList() {
        return inventoryGetUseCase.getInventoryList();
    }

    @Operation(summary = "냉장고 속 재료 수정", tags = {"InventoryController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "재료 수정 성공"),
            @ApiResponse(responseCode = "404", description = "재료 수정 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/inventory/update")
    public void updateInventory(@RequestBody InventoryRequest.InventoryUpdateRequest inventoryUpdateRequest) {
        inventoryUpdateUseCase.updateInventory(inventoryUpdateRequest);
    }

    @Operation(summary = "유통기한 얼마 남지 않은 재료 리스트 조회", tags = {"InventoryController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "유통기한 얼마 남지 않은 재료 리스트 조회 성공"),
            @ApiResponse(responseCode = "404", description = "유통기한 얼마 남지 않은 재료 리스트 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/inventory/expirationDate")
    public List<InventoryResponse.InventoryInfoResponse> getInventoryListByExpirationDate() {
        return inventoryGetUseCase.getInventoryListByExpirationDate();
    }

    @Operation(summary = "태그된 재료 정보 조회", tags = {"InventoryController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "태그된 재료 정보 조회 성공"),
            @ApiResponse(responseCode = "404", description = "태그된 재료 정보 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/inventory/tag")
    public List<InventoryResponse.InventoryTagInfoResponse> getTagInfo() {
        return inventoryGetUseCase.getTagInfo();
    }
}
