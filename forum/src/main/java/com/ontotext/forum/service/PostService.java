package com.ontotext.forum.service;

import com.ontotext.forum.dtos.PostDto;
import com.ontotext.forum.entity.Post;
import com.ontotext.forum.mappers.PostMapper;
import com.ontotext.forum.repository.PostsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Defines a service for posts which enables the post controller to execute CRUD operations on the repository.
 */
@AllArgsConstructor
@Service
public class PostService {
    private final PostsRepository repository;
    private final PostMapper postMapper;

    public PostDto createPost(PostDto postDto) {
        Post postEntity = postMapper.toPost(postDto);
        Post createdPost = repository.save(postEntity);
        return postMapper.toPostDto(createdPost);
    }

    public List<PostDto> getPosts(Pageable pageable) {
        return repository.findAll(pageable).getContent().stream().map(postMapper::toPostDto).collect(Collectors.toList());
    }

    public PostDto getPostById(Long id) {
        Post postEntity = findPostById(id);
        return postMapper.toPostDto(postEntity);
    }

    public PostDto getPostByTitle(String title) {
        Post postEntity = findPostByTitle(title);
        return postMapper.toPostDto(postEntity);
    }

    public String deletePost(Long id) {
        repository.deleteById(id);
        return "post was successfully removed";
    }

    public PostDto updatePost(Long id, PostDto postDto) {
        Post existingPost = findPostById(id);
        existingPost.setTitle(postDto.getTitle());
        existingPost.setContent(postDto.getContent());
        repository.save(existingPost);
        return postMapper.toPostDto(existingPost);
    }

    private Post findPostById(Long id) {
        Optional<Post> postOptionalEntity = repository.findById(id);
        if (!postOptionalEntity.isPresent()) {
            throw new EntityNotFoundException("Post with id " + id + " is not found");
        }
        return postOptionalEntity.get();
    }

    private Post findPostByTitle(String title) {
        Post postEntity = repository.findByTitle(title);
        if (postEntity == null) {
            throw new EntityNotFoundException("Post with title " + title + " is not found");
        }
        return postEntity;
    }
}
