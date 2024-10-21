package com.blog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.PostRequestDTO;
import com.blog.dto.PostResponseDTO;
import com.blog.model.Post;
import com.blog.repository.PostRepository;


@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostResponseDTO createPost(PostRequestDTO request) {
        Post post = new Post();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        Post savedPost = postRepository.save(post);
        return mapToResponseDTO(savedPost);
    }

    public PostResponseDTO updatePost(Long id, PostRequestDTO request) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setUpdatedAt(LocalDateTime.now());
        Post updatedPost = postRepository.save(post);
        return mapToResponseDTO(updatedPost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public List<PostResponseDTO> getAllPosts() {
        return postRepository.findAll().stream().map(this::mapToResponseDTO).collect(Collectors.toList());
    }

    public List<PostResponseDTO> searchPosts(String keyword) {
        return postRepository.findByTitleContainingOrContentContaining(keyword, keyword)
                             .stream()
                             .map(this::mapToResponseDTO)
                             .collect(Collectors.toList());
    }

    private PostResponseDTO mapToResponseDTO(Post post) {
        PostResponseDTO responseDTO = new PostResponseDTO();
        responseDTO.setId(post.getId());
        responseDTO.setTitle(post.getTitle());
        responseDTO.setContent(post.getContent());
        responseDTO.setCreatedAt(post.getCreatedAt());
        responseDTO.setUpdatedAt(post.getUpdatedAt());
        return responseDTO;
    }
}