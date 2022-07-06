package com.example.Project2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    private long id;
    private String userName;
    private Integer userRating;
    private String userComment;
}
