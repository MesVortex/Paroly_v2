package com.youcode.paroly.service.impl;

import com.youcode.paroly.dto.request.AlbumRequestDTO;
import com.youcode.paroly.dto.response.AlbumResponseDTO;
import com.youcode.paroly.entity.Album;
import com.youcode.paroly.mapper.AlbumMapper;
import com.youcode.paroly.repository.AlbumRepository;
import com.youcode.paroly.service.Interface.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    public Page<AlbumResponseDTO> getAllAlbums(Pageable pageable) {
        return albumRepository.findAll(pageable).map(albumMapper::toDTO);
    }

    @Override
    public Page<AlbumResponseDTO> searchAlbumsByTitle(String title, Pageable pageable) {
        return albumRepository.findByTitleContaining(title, pageable).map(albumMapper::toDTO);
    }

    @Override
    public Page<AlbumResponseDTO> searchAlbumsByArtist(String artist, Pageable pageable) {
        return albumRepository.findByArtist(artist, pageable).map(albumMapper::toDTO);
    }

    @Override
    public Page<AlbumResponseDTO> filterAlbumsByYear(Integer year, Pageable pageable) {
        return albumRepository.findByYear(year, pageable).map(albumMapper::toDTO);
    }

    @Override
    public AlbumResponseDTO createAlbum(AlbumRequestDTO albumDTO) {
        Album album = albumMapper.toEntity(albumDTO);
        return albumMapper.toDTO(albumRepository.save(album));
    }

    @Override
    public AlbumResponseDTO updateAlbum(String id, AlbumRequestDTO albumDTO) {
        Album album = albumMapper.toEntity(albumDTO);
        album.setId(id);
        return albumMapper.toDTO(albumRepository.save(album));
    }

    @Override
    public void deleteAlbum(String id) {
        albumRepository.deleteById(id);
    }
}
