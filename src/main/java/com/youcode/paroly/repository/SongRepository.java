package com.youcode.paroly.repository;

import com.youcode.paroly.entity.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
    Page<Song> findByTitleContaining(String title, Pageable pageable);
    Page<Song> findByAlbumId(String albumId, Pageable pageable);
}
