package com.example.Task_3.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Task_3.models.*;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

}
