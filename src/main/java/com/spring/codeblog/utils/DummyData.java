package com.spring.codeblog.utils;

import java.time.LocalDate;
import java.util.ArrayList;

//import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;

@Component
public class DummyData {
	@Autowired
	CodeblogRepository codeblogRepository;
	
	//@PostConstruct
	public void savePost() {
		ArrayList<Post> postList = new ArrayList<>();
		
		Post post1 = new Post();
		post1.setAutor("Autor Teste 3");
		post1.setTitulo("Titulo teste 3");
		post1.setData(LocalDate.now());
		post1.setText("Lorem ipsum dolor sit amet consectetur adipiscing elit, vestibulum class interdum himenaeos nec dictum, ultrices semper aptent aliquet a dapibus. Venenatis a eget fames convallis, adipiscing mauris sollicitudin euismod pellentesque, interdum finibus egestas. Lorem ipsum consequat cubilia ornare primis adipiscing penatibus venenatis, mollis ad dapibus bibendum etiam class inceptos, phasellus felis in tellus fringilla commodo condimentum. Etiam augue curabitur accumsan aliquam elementum nostra himenaeos semper cursus quis, platea justo ante odio dictum gravida non ultrices. Enim lorem placerat interdum id aliquam inceptos maximus vel mattis hac, ac egestas condimentum netus convallis sollicitudin elit neque ut, varius metus iaculis quis eleifend habitasse primis sit faucibus. Auctor magnis dignissim senectus felis eget consequat feugiat vestibulum lacinia, justo habitasse class tortor eros ornare convallis rhoncus et condimentum, suspendisse cursus nisi quam sem fusce hendrerit tellus. Justo convallis tempor libero lacus magna suscipit maecenas rutrum, mattis ut ipsum neque aenean porttitor hac, integer ridiculus non vel lorem commodo pellentesque. Efficitur dictum condimentum purus rutrum ad mauris, netus ac lobortis cras taciti pellentesque, enim laoreet nam ligula suspendisse.");
		
		Post post2 = new Post();
		post2.setAutor("Autor Teste 4");
		post2.setTitulo("Titulo teste 4");
		post2.setData(LocalDate.now());
		post2.setText("Lorem ipsum dolor sit amet consectetur adipiscing elit, vestibulum class interdum himenaeos nec dictum, ultrices semper aptent aliquet a dapibus. Venenatis a eget fames convallis, adipiscing mauris sollicitudin euismod pellentesque, interdum finibus egestas. Lorem ipsum consequat cubilia ornare primis adipiscing penatibus venenatis, mollis ad dapibus bibendum etiam class inceptos, phasellus felis in tellus fringilla commodo condimentum. Etiam augue curabitur accumsan aliquam elementum nostra himenaeos semper cursus quis, platea justo ante odio dictum gravida non ultrices. Enim lorem placerat interdum id aliquam inceptos maximus vel mattis hac, ac egestas condimentum netus convallis sollicitudin elit neque ut, varius metus iaculis quis eleifend habitasse primis sit faucibus. Auctor magnis dignissim senectus felis eget consequat feugiat vestibulum lacinia, justo habitasse class tortor eros ornare convallis rhoncus et condimentum, suspendisse cursus nisi quam sem fusce hendrerit tellus. Justo convallis tempor libero lacus magna suscipit maecenas rutrum, mattis ut ipsum neque aenean porttitor hac, integer ridiculus non vel lorem commodo pellentesque. Efficitur dictum condimentum purus rutrum ad mauris, netus ac lobortis cras taciti pellentesque, enim laoreet nam ligula suspendisse.");
		
		postList.add(post1);
		postList.add(post2);
		
		for (Post post: postList) {
			Post savedPost = codeblogRepository.save(post);
			System.out.println("Test post with Id " + savedPost.getId() + " was saved!");
		}
	}
	
}
