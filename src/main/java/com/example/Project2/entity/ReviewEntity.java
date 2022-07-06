package com.example.Project2.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private Integer userRating;
    private String userComment;
}
