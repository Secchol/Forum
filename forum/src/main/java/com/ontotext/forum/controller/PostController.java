package com.ontotext.forum.controller;

import com.ontotext.forum.entity.Post;
import com.ontotext.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
  @Autowired private PostService service;

  @PostMapping("/")
  public Post createPost(@RequestBody Post post) {
    return service.createPost(post);
  }

  @PatchMapping("/{id}")
  public Post updatePostById(@RequestBody Post post) {
    return service.updatePost(post);
  }

  @DeleteMapping("/{id}")
  public String deletePostById(@PathVariable Long id) {
    return service.deletePost(id);
  }

  @GetMapping
  public Page<Post> getPosts(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
    return service.getPosts(PageRequest.of(page, size));
  }

  @GetMapping("/{id}")
  public Post getPostById(@PathVariable Long id) {
    return service.getPostById(id);
  }

  @GetMapping("/{title}")
  public Post getPostByTitle(@PathVariable String title) {
    return service.getPostByTitle(title);
  }
}
