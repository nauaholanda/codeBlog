package com.spring.codeblog.service;

import java.util.ArrayList;

import com.spring.codeblog.model.Post;

public interface CodeblogService {
	ArrayList<Post> findAll();
	ArrayList<Post> findAllByOrderByIdDesc();
	Post findById(long id);
	Post save(Post post);
	String deleteById(long id);
	
}
