package com.spring.codeblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.codeblog.model.Post;

public interface CodeblogRepository extends JpaRepository<Post, Long>{
	public List<Post> findAllByOrderByIdDesc();
}
