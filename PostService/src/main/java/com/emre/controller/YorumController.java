package com.emre.controller;

import com.emre.service.YorumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class YorumController {

    private final YorumService yorumService;
}
