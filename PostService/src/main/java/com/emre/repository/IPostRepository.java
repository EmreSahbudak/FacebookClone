package com.emre.repository;

import com.emre.repository.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends MongoRepository<Post,String> {
}
