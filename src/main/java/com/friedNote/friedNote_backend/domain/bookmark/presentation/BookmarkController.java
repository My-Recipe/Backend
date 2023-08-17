package com.friedNote.friedNote_backend.domain.bookmark.presentation;

import com.friedNote.friedNote_backend.domain.bookmark.applicatoin.dto.request.BookmarkRequest;
import com.friedNote.friedNote_backend.domain.bookmark.applicatoin.service.BookmarkCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkCreateService bookmarkCreateService;

    @PostMapping("/bookmark")
    public void createBookmark(@RequestBody BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        bookmarkCreateService.createBookmark(bookmarkCreateRequest);
    }
}
