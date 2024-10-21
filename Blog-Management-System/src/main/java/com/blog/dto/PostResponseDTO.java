package com.blog.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class PostResponseDTO {
	
	private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<CommentResponseDTO> comments;

}
