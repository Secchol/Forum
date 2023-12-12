package com.ontotext.forum.dtos;

import jakarta.persistence.GeneratedValue;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class PostDTO {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
}
