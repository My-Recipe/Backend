package com.friedNote.friedNote_backend.domain.bookmark.domain.repository;

import com.friedNote.friedNote_backend.domain.bookmark.domain.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
}
