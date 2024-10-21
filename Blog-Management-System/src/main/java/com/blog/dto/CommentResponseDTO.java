package com.blog.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentResponseDTO {
	private Long id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
