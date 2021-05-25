package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;

@Controller
public class CodeblogController {
	
	@Autowired
	CodeblogService codeblogService;
	
	@GetMapping("/posts")
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		
		ArrayList<Post> posts = codeblogService.findAllByOrderByIdDesc();
		
		mv.addObject("posts", posts);
		return mv;
	}
	@GetMapping("/posts/{id}")
	public ModelAndView getPostDetails(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("postDetails");
		
		Post post = codeblogService.findById(id);
		
		mv.addObject("post", post);
		return mv;
	}
	
	@GetMapping("/newpost")
	public String getPostForm() {
		return "postForm";
	}
	
	@PostMapping("/newpost")
	public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes, String titulo, String autor, String text) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("newTitulo", titulo);
			attributes.addFlashAttribute("newAutor", autor);
			attributes.addFlashAttribute("newText", text);
			attributes.addFlashAttribute("mensagem", "Verifique se todos os campos obrigatórios foram preenchidos!");
			return "redirect:/newpost";
			
		}
		post.setData(LocalDate.now());
		codeblogService.save(post);
		return "redirect:/posts";
	}
	
	@GetMapping("/deletepost/{id}")
	public String deleteGet(@PathVariable("id") Long id, RedirectAttributes attributes) {
		Post post = codeblogService.findById(id);
		String title = post.getTitulo();
		String me = "O post '" + title + "' foi deletado com sucesso!";
		
		attributes.addFlashAttribute("mensagem", me);
		
		codeblogService.deleteById(id);
		
		return "redirect:/posts";
	}
	
	@GetMapping("/updatepost/{id}")
	public ModelAndView getUpdateForm(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("updateForm");
		Post post = codeblogService.findById(id);
		
		mv.addObject("post", post);
		return mv;
	}
	
	@PostMapping("/updatepost/{id}")
	public String updatePost(@Valid Post post, BindingResult result, RedirectAttributes attributes, @PathVariable Long id, String titulo, String autor, String text) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se todos os campos obrigatórios foram preenchidos!");
			attributes.addFlashAttribute("newTitulo", titulo);
			attributes.addFlashAttribute("newAutor", autor);
			attributes.addFlashAttribute("newText", text);
			String red = "redirect:/updatepost/" + id;
			return red;
		}
		post.setData(LocalDate.now());
		codeblogService.save(post);
		attributes.addFlashAttribute("mensagem", "Post alterado com sucesso!");
		String red = "redirect:/posts/" + id;
		return red;
	}
	
	
}
