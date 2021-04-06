package com.example.workshopmong.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmong.domain.User;
import com.example.workshopmong.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;

	public List<User> findAll(){
		return repository.findAll();
	}
}
