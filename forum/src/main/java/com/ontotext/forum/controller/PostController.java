package com.ontotext.forum.controller;

import com.ontotext.forum.dtos.PostDto;
import com.ontotext.forum.exceptions.ResourceNotFoundException;
import com.ontotext.forum.service.PostService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Defines a REST controller that contains the endpoints for the CRUD of posts.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    private final PostService service;

    @PostMapping
    public PostDto createPost(@RequestBody PostDto postDto) {
        LOGGER.info("Post was successfully created");
        return service.createPost(postDto);
    }

    @PatchMapping("/{id}")
    public PostDto updatePostById(@PathVariable Long id, @RequestBody PostDto post) {
        try {
            return service.updatePost(id, post);
        } catch (EntityNotFoundException exception) {
            LOGGER.info("Post with id {} was not found", id);
            throw new ResourceNotFoundException("Post with id " + id + " was not found");
        }
    }

    @DeleteMapping("/{id}")
    public String deletePostById(@PathVariable Long id) {
        try {
            return service.deletePost(id);
        } catch (EntityNotFoundException exception) {
            LOGGER.info("Post with id {} was not found", id);
            throw new ResourceNotFoundException("Post with id " + id + " was not found");
        }
    }

    /**
     * Gets a page of posts with a given size.
     * @param page page number
     * @param size page size
     * @return a list of posts
     */
    @GetMapping
    public List<PostDto> getPosts(
            @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return service.getPosts(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    public PostDto getPostById(@PathVariable Long id) {
        try {
            return service.getPostById(id);
        } catch (EntityNotFoundException exception) {
            LOGGER.info("Post with id {} was not found", id);
            throw new ResourceNotFoundException("Post with id " + id + " was not found");
        }
    }

    @GetMapping("/{title}")
    public PostDto getPostByTitle(@PathVariable String title) {
        PostDto postDto = service.getPostByTitle(title);
        if (postDto == null) {
            LOGGER.info("Post with title {} was not found", title);
            throw new ResourceNotFoundException("Post with title " + title + " was not found");
        }
        return postDto;
    }
}
