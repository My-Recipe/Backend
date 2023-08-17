package com.friedNote.friedNote_backend.domain.bookmark.domain.service;

import com.friedNote.friedNote_backend.domain.bookmark.domain.entity.Bookmark;
import com.friedNote.friedNote_backend.domain.bookmark.domain.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookmarkSaveService {

    private final BookmarkRepository bookmarkRepository;

    public void saveBookmark(Bookmark bookmark) {
        bookmarkRepository.save(bookmark);
    }
}
