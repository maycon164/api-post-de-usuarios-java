package com.example.workshopmong.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.example.workshopmong.domain.Post;
import com.example.workshopmong.domain.User;
import com.example.workshopmong.dto.AuthorDTO;
import com.example.workshopmong.repository.PostRepository;
import com.example.workshopmong.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	UserRepository userRepository;

	@Autowired
	PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post p1 = new Post(null, sdf.parse("02/09/2018"), "Partiu São paulo", "Estou viajando amanhã para SP",
				new AuthorDTO(maria));
		Post p2 = new Post(null, sdf.parse("02/12/2020"), "Sangue de Jesus tem poder", "REAAU OU FEIKI",
				new AuthorDTO(bob));

		postRepository.saveAll(Arrays.asList(p1, p2));

	}

}
