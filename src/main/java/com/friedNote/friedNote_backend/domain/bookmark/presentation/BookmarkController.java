package com.friedNote.friedNote_backend.domain.bookmark.presentation;

import com.friedNote.friedNote_backend.domain.bookmark.application.dto.request.BookmarkRequest;
import com.friedNote.friedNote_backend.domain.bookmark.application.dto.response.BookmarkResponse;
import com.friedNote.friedNote_backend.domain.bookmark.application.service.BookmarkCreateUseCase;
import com.friedNote.friedNote_backend.domain.bookmark.application.service.BookmarkGetUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkCreateUseCase bookmarkCreateUseCase;
    private final BookmarkGetUseCase bookmarkGetUseCase;


    @PostMapping("/bookmark")
    public void createBookmark(@RequestBody BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        bookmarkCreateUseCase.createBookmark(bookmarkCreateRequest);
    }

    @GetMapping("/bookmark/count")
    public BookmarkResponse.BookmarkCountResponse getBookmarkCount(@RequestParam Long recipeId) {
         return bookmarkGetUseCase.getBookmarkCount(recipeId);
    }

}
