package com.blog.dto;

import lombok.Data;

@Data
public class CommentRequestDTO {
	private String content;
    private Long postId;
}
