package com.instaict.datapanel.datapanel.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JsonPlaceholderService {

	private final RestTemplate restTemplate;
	private final String api = "https://jsonplaceholder.typicode.com";

	public JsonPlaceholderService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

//	Get All
	public String getAllUsers() {

		return restTemplate.getForObject(api + "/users", String.class);
	}

	public String getAllPosts() {

		return restTemplate.getForObject(api + "/posts", String.class);
	}

	public String getAllComments() {

		return restTemplate.getForObject(api + "/comments", String.class);
	}

	public String getAllAlbums() {

		return restTemplate.getForObject(api + "/albums", String.class);
	}

	public String getAllPhotos() {

		return restTemplate.getForObject(api + "/photos", String.class);
	}

	public String getAllTodos() {

		return restTemplate.getForObject(api + "/todos", String.class);
	}

//	Get By ID
	public String getPostById(int id) {
		return restTemplate.getForObject(api + "/posts/" + id, String.class);
	}

	public String getUsersById(int id) {
		return restTemplate.getForObject(api + "/users/" + id, String.class);
	}

	public String getCommentsById(int id) {
		return restTemplate.getForObject(api + "/comments/" + id, String.class);
	}

	public String getAlbumsById(int id) {
		return restTemplate.getForObject(api + "/albums/" + id, String.class);
	}

	public String getPhotosById(int id) {
		return restTemplate.getForObject(api + "/photos/" + id, String.class);
	}

	public String getTodosById(int id) {
		return restTemplate.getForObject(api + "/todos/" + id, String.class);
	}

//	POST

	public String createPost() {
		String url = api + "/posts";

		HashMap<String, Object> data = new HashMap<>();
		data.put("title", "My first post");
		data.put("body", "Insta ICT");
		data.put("userId", 101);

		HttpHeaders head = new HttpHeaders();
		head.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> req = new HttpEntity<>(data, head);

		return restTemplate.postForObject(url, req, String.class);

	}

	public String createComment() {
		String url = api + "/comments";

		HashMap<String, Object> data = new HashMap<>();
		data.put("postId", 1);
		data.put("id", 1);
		data.put("name", "xyz");
		data.put("email", "xyz@gmail.com");
		data.put("body", "This is comment body");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> req = new HttpEntity<>(data, headers);

		return restTemplate.postForObject(url, req, String.class);
	}

	public String createTodos() {
		String url = api + "/todos";

		HashMap<String, Object> data = new HashMap<>();
		data.put("userId", 1);
		data.put("id", 1);
		data.put("title", "delectus aut autem");
		data.put("completed", false);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> req = new HttpEntity<>(data, headers);

		return restTemplate.postForObject(url, req, String.class);
	}

//	PUT

	public String updatePost(int id) {
		String url = api + "/posts/" + id;

		HashMap<String, Object> data = new HashMap<>();
		data.put("id", id);
		data.put("title", "My first post");
		data.put("body", "Insta ICT");
		data.put("userId", 1);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> req = new HttpEntity<>(data, headers);

		ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.PUT, req, String.class);
		return res.getBody();
	}

	public String updateComment(int uid) {

		String url = api + "/comments/" + uid;

		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("postId", 1);
		data.put("id", 1);
		data.put("name", "xyz");
		data.put("email", "xyz@gmail.com");
		data.put("body", "This is updated comment body");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> req = new HttpEntity<>(data, headers);

		ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.PUT, req, String.class);
		return res.getBody();
	}

	public String updateTodos(int uid) {

		String url = api + "/todos/" + uid;

		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("id", uid);
		data.put("Title", "My first todo list");
		data.put("completed", false);
		data.put("userId", 1);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Map<String, Object>> req = new HttpEntity<>(data, headers);

		ResponseEntity<String> res = restTemplate.exchange(url, HttpMethod.PUT, req, String.class);
		return res.getBody();
	}

	
//	DELETE
	
	public String deletePost(int id) {
		String url = api + "/posts/" + id;
		restTemplate.delete(url);
		return "deleted Post " + id;
	}

	public String deleteComment(int id) {
		String url = api + "/comments/" + id;
		restTemplate.delete(url);
		return "Deleted Comment " + id;
	}

	public String deleteTodos(int id) {
		String url = api + "/todos/" + id;
		restTemplate.delete(url);
		return "Deleted Todo " + id;
	}

}
