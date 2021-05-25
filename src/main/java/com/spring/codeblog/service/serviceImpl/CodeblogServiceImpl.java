package com.spring.codeblog.service.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import com.spring.codeblog.service.CodeblogService;

@Transactional
@Service
public class CodeblogServiceImpl implements CodeblogService{
	
	@Autowired
	CodeblogRepository codeblogRepository;
	
	@Override
	public ArrayList<Post> findAll() {
		return (ArrayList<Post>) codeblogRepository.findAll();
	}
	
	@Override
	public ArrayList<Post> findAllByOrderByIdDesc() {
		return (ArrayList<Post>) codeblogRepository.findAllByOrderByIdDesc();
	}

	@Override
	public Post findById(long id) {
		return codeblogRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return codeblogRepository.save(post);
	}

	@Override
	public String deleteById(long id) {
		codeblogRepository.deleteById(id);
		return null;
	}


}
