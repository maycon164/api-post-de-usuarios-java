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
import com.example.workshopmong.dto.CommentDTO;
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
		
		CommentDTO c1 = new CommentDTO("Boa Sorte para não ser roubado", sdf.parse("03/09/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Feikki", sdf.parse("04/12/2020"), new AuthorDTO(alex));
		
		p1.getComments().add(c1);
		p2.getComments().add(c2);
		
		maria.getPosts().add(p1);
		bob.getPosts().add(p2);

		postRepository.saveAll(Arrays.asList(p1, p2));

		userRepository.saveAll(Arrays.asList(maria, bob));
	}

}
