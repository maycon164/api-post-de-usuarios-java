package com.example.workshopmong.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.workshopmong.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> findByTitle(String txt);

	List<Post> findByTitleContainingIgnoreCase(String txt);
}
