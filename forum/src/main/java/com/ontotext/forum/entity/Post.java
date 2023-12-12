package com.ontotext.forum.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post extends TimestampedEntity {
  @Id @GeneratedValue private Long id;
  private String title;
  private String content;

}
