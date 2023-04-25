package com.emre.controller;

import com.emre.service.BegeniService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class BegeniController {

    private final BegeniService begeniService;
}
