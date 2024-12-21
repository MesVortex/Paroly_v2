package com.youcode.paroly.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SongRequestDTO {
    private String id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must not exceed 100 characters")
    private String title;

    @NotNull(message = "Duration is required")
    @Positive(message = "Duration must be a positive number")
    private Integer duree;

    @NotNull(message = "Track number is required")
    @Positive(message = "Track number must be a positive number")
    private Integer trackNumber;

    @NotBlank(message = "Album ID is required")
    private String albumId;
}
