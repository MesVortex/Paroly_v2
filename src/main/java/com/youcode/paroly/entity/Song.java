package com.youcode.paroly.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Song {

    @Id
    private String id;

    private String title;

    private Integer duree;

    private Integer trackNumber;

    private Album album;
}

