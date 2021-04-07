package com.example.workshopmong.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmong.domain.Post;
import com.example.workshopmong.repository.PostRepository;
import com.example.workshopmong.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id));
	}
	
	public List<Post> findByTitle(String txt){
		return repository.findByTitleContainingIgnoreCase(txt);
	}
}
