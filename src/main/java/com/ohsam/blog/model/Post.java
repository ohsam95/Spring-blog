package com.ohsam.blog.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
	
	private int id;
	private String title;
	private String content;
	private int userId;
	private Timestamp createDate;
	
}
