package com.douglas.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.workshopmongo.domain.Post;
import com.douglas.workshopmongo.repository.PostRepository;
import com.douglas.workshopmongo.servises.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	public Post insert(Post obj) {
		return repo.insert(obj);
	}
	
	public List<Post> FindByTitle(String text){
		return repo.searchTitle(text);
	}
	
}