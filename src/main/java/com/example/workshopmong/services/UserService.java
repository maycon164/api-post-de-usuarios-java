package com.example.workshopmong.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmong.domain.User;
import com.example.workshopmong.dto.UserDTO;
import com.example.workshopmong.repository.UserRepository;
import com.example.workshopmong.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado id: " + id));
	}
	
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}

	public User fromDTO(UserDTO user) {
		return new User(user.getId(), user.getName(), user.getEmail());
	}
}
