package com.friedNote.friedNote_backend.domain.bookmark.presentation;

import com.friedNote.friedNote_backend.common.exception.dto.ErrorResponse;
import com.friedNote.friedNote_backend.domain.bookmark.application.dto.request.BookmarkRequest;
import com.friedNote.friedNote_backend.domain.bookmark.application.dto.response.BookmarkResponse;
import com.friedNote.friedNote_backend.domain.bookmark.application.service.BookmarkCreateUseCase;
import com.friedNote.friedNote_backend.domain.bookmark.application.service.BookmarkGetUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkCreateUseCase bookmarkCreateUseCase;
    private final BookmarkGetUseCase bookmarkGetUseCase;

    @Operation(summary = "북마크 생성", tags = {"BookmarkController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "북마크 생성 성공"),
            @ApiResponse(responseCode = "404", description = "북마크 생성 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/bookmark")
    public void createBookmark(@Parameter(description = "북마크 생성 요청"
            ,schema = @Schema(implementation = BookmarkRequest.BookmarkCreateRequest.class))
            @RequestBody BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        bookmarkCreateUseCase.createBookmark(bookmarkCreateRequest);
    }


    @Operation(summary = "북마크 개수 조회", tags = {"BookmarkController"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "북마크 개수 조회 성공"),
            @ApiResponse(responseCode = "404", description = "북마크 개수 조회 실패",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/bookmark/count")
    public BookmarkResponse.BookmarkCountResponse getBookmarkCount(@RequestParam Long recipeId) {
         return bookmarkGetUseCase.getBookmarkCount(recipeId);
    }

}
