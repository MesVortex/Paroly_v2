package com.youcode.paroly.mapper;

import com.youcode.paroly.dto.request.SongRequestDTO;
import com.youcode.paroly.dto.response.SongResponseDTO;
import com.youcode.paroly.entity.Song;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongMapper {

    @Mapping(source = "album.id", target = "albumId")
    SongResponseDTO toDTO(Song song);

    @Mapping(target = "album", ignore = true)
    Song toEntity(SongRequestDTO songRequestDTO);
}
