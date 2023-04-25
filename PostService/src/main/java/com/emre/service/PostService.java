package com.emre.service;

import com.emre.repository.IPostRepository;
import com.emre.repository.entity.Post;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PostService extends ServiceManager<Post,String> {

    private final IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        super(postRepository);
        this.postRepository = postRepository;
    }
}
