package com.instaict.datapanel.datapanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.instaict.datapanel.datapanel.service.JsonPlaceholderService;

@RestController
@RequestMapping("/api")
public class DataController {

	@Autowired
	private JsonPlaceholderService service;

//	GET
	
	@GetMapping("/getPosts")
	public String getAllPosts() {
		return service.getAllPosts();
	}
	
	@GetMapping("/getComments")
	public String getAllComments() {
		return service.getAllComments();
	}
	
	@GetMapping("/getAlbums")
	public String getAllAlbums() {
		return service.getAllAlbums();
	}
	
	@GetMapping("/getPhotos")
	public String getAllPhotos() {
		return service.getAllPhotos();
	}
	
	@GetMapping("/getTodos")
	public String getAllTodos() {
		return service.getAllTodos();
	}
	
	@GetMapping("/getUsers")
	public String getAllUsers() {
		return service.getAllUsers();
	}
	
	
//	GET By ID
	@GetMapping("/getbyiduser/{id}")
	public String getUsersById(@PathVariable int id) {
		return service.getUsersById(id);

	}
	
	@GetMapping("/getbyidposts/{id}")
	public String getPostById(@PathVariable int id) {
		return service.getPostById(id);

	}
	
	@GetMapping("/getbyidcomments/{id}")
	public String getCommentsById(@PathVariable int id) {
		return service.getCommentsById(id);

	}
	
	@GetMapping("/getbyidalbums/{id}")
	public String getAlbumsById(@PathVariable int id) {
		return service.getAlbumsById(id);

	}
	
	@GetMapping("/getbyidphotos/{id}")
	public String getPhotosById(@PathVariable int id) {
		return service.getPhotosById(id);

	}
	
	@GetMapping("/getbyidtodos/{id}")
	public String getTodosById(@PathVariable int id) {
		return service.getTodosById(id);

	}
	
	
//	POST
	@PostMapping("/posts")
	public String createPost() {
		return service.createPost();
	}
	
	@PostMapping("/comments")
	public String createComment() {
		return service.createComment();
	}

	@PostMapping("/todos")
	public String createTodos() {
		return service.createTodos();
	}

	
//	PUT
	@PutMapping("/updatepost/{uid}")
	public String updatePost(@PathVariable int uid) {
		return service.updatePost(uid);
	}
	
	@PutMapping("/updatecomment/{uid}")
	public String updateComment(@PathVariable int uid) {
		return service.updateComment(uid);
	}
	
	@PutMapping("/updatetodos/{uid}")
	public String updateTodos(@PathVariable int uid) {
		return service.updateTodos(uid);
	}
	
	
//	DELETE
	@DeleteMapping("/deletepost/{id}")
	public String deletePost(@PathVariable int id) {
		return service.deletePost(id);
	}
	
	@DeleteMapping("/deletecomments/{id}")
	public String deleteComment(@PathVariable int id) {
		return service.deleteComment(id);
	}
	
	@DeleteMapping("/deletetodos/{id}")
	public String deleteTodos(@PathVariable int id) {
		return service.deleteTodos(id);
	}
}
