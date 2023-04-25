package com.emre.repository;

import com.emre.repository.entity.PostResim;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostResimRepository extends MongoRepository<PostResim,String> {
}
