package com.youcode.paroly.mapper;

import com.youcode.paroly.dto.request.AlbumRequestDTO;
import com.youcode.paroly.dto.response.AlbumResponseDTO;
import com.youcode.paroly.entity.Album;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    AlbumResponseDTO toDTO(Album album);
    Album toEntity(AlbumRequestDTO albumRequestDTO);
}
