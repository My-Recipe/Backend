package com.friedNote.friedNote_backend.domain.bookmark.application.service;

import com.friedNote.friedNote_backend.common.annotation.UseCase;
import com.friedNote.friedNote_backend.domain.bookmark.application.dto.response.BookmarkResponse;
import com.friedNote.friedNote_backend.domain.bookmark.application.mapper.BookmarkMapper;
import com.friedNote.friedNote_backend.domain.bookmark.domain.service.BookmarkQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@UseCase
@RequiredArgsConstructor
@Transactional
public class BookmarkGetUseCase {

    private final BookmarkQueryService bookmarkQueryService;

    public List<BookmarkResponse.BookmarkInfoResponse> getBookmarkInfo(Long userId) {
        return bookmarkQueryService.findByUserId(userId)
                .stream().map(bookmark -> BookmarkMapper.mapToBookmarkInfoResponse(bookmark))
                .collect(toList());
    }

    public BookmarkResponse.BookmarkCountResponse getBookmarkCount(Long recipeId) {
        Long count = bookmarkQueryService.countByRecipeId(recipeId);
        return BookmarkMapper.mapToBookMarkCountResponse(count);
    }
}
