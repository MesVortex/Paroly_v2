package com.youcode.paroly.entity;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "albums")
public class Album {

    @Id
    private String id;

    private String title;

    private String artist;

    private Integer year;

    private List<Song> chansons;
}

