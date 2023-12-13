package com.ontotext.forum.dtos;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * Defines a DTO of the post entity.
 */
@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private Date createDate;
    private Date modifyDate;
}
