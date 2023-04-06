package com.emre.controller;

import com.emre.dto.request.LoginRequestDto;
import com.emre.dto.request.RegisterRequestDto;
import com.emre.dto.response.LoginResponseDto;
import com.emre.dto.response.RegisterResponseDto;
import com.emre.exception.AuthException;
import com.emre.exception.ErrorType;
import com.emre.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Valid LoginRequestDto dto){
        if (!authService.doLogin(dto))
            return ResponseEntity.ok(LoginResponseDto.builder()
                            .statusCode(4000)
                            .message("Kullanıcı adı veya şifre yanlış")
                    .build());
        return ResponseEntity.ok(LoginResponseDto.builder()
                        .statusCode(2001)
                        .message("Giriş işlemi başarılı")
                .build());
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){
        if (dto.getPassword().equals(dto.getRepassword()))
            throw new AuthException(ErrorType.ERROR_PASSWORD);
            authService.register(dto);
            return ResponseEntity.ok(RegisterResponseDto.builder()
                            .statusCode(2000)
                            .message("Kayıt işlemi başarılı şekilde gerçekleşti." +
                                    "Eposta adresinize gelen aktivasyonu doğrulayınız.")
                    .build());
    }
}
