package com.protosyte.demo.model;


import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import javax.persistence.Id;
import org.springframework.lang.Nullable;

import lombok.Data;

@Data
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long postId;
	@NotBlank(message="postName cannot be empty")
	private String postName;
	@Nullable
	private String url;
	@Lob //Large Object
	private String description;
	
	private Integer voteCount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private User user;
	
	private Instant createdDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id", referencedColumnName="id")
	private Subreddit subreddit;
}
