package com.friedNote.friedNote_backend.domain.bookmark.presentation;

import com.friedNote.friedNote_backend.domain.bookmark.application.dto.request.BookmarkRequest;
import com.friedNote.friedNote_backend.domain.bookmark.application.service.BookmarkCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkCreateUseCase bookmarkCreateUseCase;
//    private final BookmarkGetService bookmarkGetService;


    @PostMapping("/bookmark")
    public void createBookmark(@RequestBody BookmarkRequest.BookmarkCreateRequest bookmarkCreateRequest) {
        bookmarkCreateUseCase.createBookmark(bookmarkCreateRequest);
    }

//    @GetMapping("/getBookmarkList")
//    public List<BookmarkResponse.BookmarkInfoResponse> getBookmarkList(Long userId) {
//        return bookmarkGetService.getBookmarkInfo(userId);
//    }

}
