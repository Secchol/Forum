package com.ontotext.forum.repository;

import com.ontotext.forum.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Defines a repository for posts.
 */
@Repository
public interface PostsRepository extends JpaRepository<Post, Long> {
  Post findByTitle(String title);
}
