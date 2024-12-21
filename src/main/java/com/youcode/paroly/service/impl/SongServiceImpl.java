package com.youcode.paroly.service.impl;

import com.youcode.paroly.dto.request.SongRequestDTO;
import com.youcode.paroly.dto.response.SongResponseDTO;
import com.youcode.paroly.entity.Album;
import com.youcode.paroly.entity.Song;
import com.youcode.paroly.mapper.SongMapper;
import com.youcode.paroly.repository.AlbumRepository;
import com.youcode.paroly.repository.SongRepository;
import com.youcode.paroly.service.Interface.SongService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SongServiceImpl implements SongService {

    private SongRepository songRepository;
    private AlbumRepository albumRepository;
    private SongMapper songMapper;

    @Override
    public Page<SongResponseDTO> getAllSongs(Pageable pageable) {
        return songRepository.findAll(pageable).map(songMapper::toDTO);
    }

    @Override
    public Page<SongResponseDTO> searchSongsByTitle(String title, Pageable pageable) {
        return songRepository.findByTitleContaining(title, pageable).map(songMapper::toDTO);
    }

    @Override
    public Page<SongResponseDTO> getSongsByAlbumId(String albumId, Pageable pageable) {
        return songRepository.findByAlbumId(albumId, pageable).map(songMapper::toDTO);
    }

    @Override
    public SongResponseDTO createSong(SongRequestDTO songDTO) {
        Album album = albumRepository.findById(songDTO.getAlbumId())
                .orElseThrow(() -> new IllegalArgumentException("Album not found"));
        Song song = songMapper.toEntity(songDTO);
        song.setAlbum(album);
        return songMapper.toDTO(songRepository.save(song));
    }

    @Override
    public SongResponseDTO updateSong(String id, SongRequestDTO songDTO) {
        Album album = albumRepository.findById(songDTO.getAlbumId())
                .orElseThrow(() -> new IllegalArgumentException("Album not found"));
        Song song = songMapper.toEntity(songDTO);
        song.setAlbum(album);
        song.setId(id);
        return songMapper.toDTO(songRepository.save(song));
    }

    @Override
    public void deleteSong(String id) {
       songRepository.deleteById(id);
    }
}
