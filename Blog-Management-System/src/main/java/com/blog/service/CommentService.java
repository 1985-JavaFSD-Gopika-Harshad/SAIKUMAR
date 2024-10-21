package com.blog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dto.CommentRequestDTO;
import com.blog.dto.CommentResponseDTO;
import com.blog.model.Comment;
import com.blog.model.Post;
import com.blog.repository.CommentRepository;
import com.blog.repository.PostRepository;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public CommentResponseDTO addComment(CommentRequestDTO request) {
        Post post = postRepository.findById(request.getPostId()).orElseThrow();
        Comment comment = new Comment();
        comment.setContent(request.getContent());
        comment.setPost(post);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUpdatedAt(LocalDateTime.now());
        Comment savedComment = commentRepository.save(comment);
        return mapToResponseDTO(savedComment);
    }

    public CommentResponseDTO updateComment(Long id, CommentRequestDTO request) {
        Comment comment = commentRepository.findById(id).orElseThrow();
        comment.setContent(request.getContent());
        comment.setUpdatedAt(LocalDateTime.now());
        Comment updatedComment = commentRepository.save(comment);
        return mapToResponseDTO(updatedComment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }

    public List<CommentResponseDTO> getAllCommentsForPost(Long postId) {
        return commentRepository.findByPostId(postId).stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public List<CommentResponseDTO> searchComments(String keyword) {
        return commentRepository.findByContentContaining(keyword)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    private CommentResponseDTO mapToResponseDTO(Comment comment) {
        CommentResponseDTO responseDTO = new CommentResponseDTO();
        responseDTO.setId(comment.getId());
        responseDTO.setContent(comment.getContent());
        responseDTO.setCreatedAt(comment.getCreatedAt());
        responseDTO.setUpdatedAt(comment.getUpdatedAt());
        return responseDTO;
    }
}
