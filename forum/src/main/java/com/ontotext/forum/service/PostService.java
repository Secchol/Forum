package com.ontotext.forum.service;

import com.ontotext.forum.entity.Post;
import com.ontotext.forum.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  @Autowired private PostsRepository repository;

  public Post createPost(Post post) {
    return repository.save(post);
  }

  public Page<Post> getPosts(Pageable pageable) {
    return repository.findAll(pageable);
  }

  public Post getPostById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public Post getPostByTitle(String title) {
    return repository.findByTitle(title);
  }

  public String deletePost(Long id) {
    repository.deleteById(id);
    return "post removed " + id;
  }

  public Post updatePost(Post post) {
    Post existingPost = repository.findById(post.getId()).orElse(null);
    existingPost.setTitle(post.getTitle());
    existingPost.setContent(post.getContent());
    existingPost.setCreationDate(post.getCreationDate());
    return repository.save(existingPost);
  }
}
