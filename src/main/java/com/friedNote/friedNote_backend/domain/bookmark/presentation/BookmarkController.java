package com.friedNote.friedNote_backend.domain.bookmark.presentation;

import com.friedNote.friedNote_backend.domain.bookmark.application.dto.request.BookmarkRequest;
import com.friedNote.friedNote_backend.domain.bookmark.application.dto.response.BookmarkResponse;
import com.friedNote.friedNote_backend.domain.bookmark.application.service.BookmarkCreateService;
import com.friedNote.friedNote_backend.domain.bookmark.application.service.BookmarkGetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkCreateService bookmarkCreateService;
    private final BookmarkGetService bookmarkGetService;


    @PostMapping("/bookmark")
    public void createBookmark(@RequestBody BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        bookmarkCreateService.createBookmark(bookmarkCreateRequest);
    }

    @GetMapping("/bookmark")
    public List<BookmarkResponse.BookmarkInfoResponse> getBookmark(Long userId) {
        return bookmarkGetService.getBookmarkInfo(userId);
    }

}
