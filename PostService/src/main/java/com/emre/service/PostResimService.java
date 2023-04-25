package com.emre.service;

import com.emre.repository.IPostResimRepository;
import com.emre.repository.entity.PostResim;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class PostResimService extends ServiceManager<PostResim,String> {

    private final IPostResimRepository postResimRepository;

    public PostResimService(IPostResimRepository postResimRepository) {
        super(postResimRepository);
        this.postResimRepository = postResimRepository;
    }
}
