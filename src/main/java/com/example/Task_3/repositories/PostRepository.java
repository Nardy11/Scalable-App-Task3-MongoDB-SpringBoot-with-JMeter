package com.example.Task_3.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Task_3.models.*;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    @Query("{ 'author.id': ?0 }")  
    List<Post> getPostsByAuthorID(String authorID);
}

