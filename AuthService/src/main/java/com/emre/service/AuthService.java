package com.emre.service;

import com.emre.dto.request.LoginRequestDto;
import com.emre.dto.request.RegisterRequestDto;
import com.emre.exception.AuthException;
import com.emre.exception.ErrorType;
import com.emre.mapper.IAuthMapper;
import com.emre.repository.IAuthRepository;
import com.emre.repository.entity.Auth;
import com.emre.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth,Long> {

    private final IAuthRepository authRepository;

    public AuthService(IAuthRepository authRepository) {
        super(authRepository);
        this.authRepository = authRepository;
    }
    public boolean doLogin(LoginRequestDto dto){
        Optional<Auth> auth=authRepository.findOptionalByUsernameAndPassword(
                dto.getUsername(),dto.getPassword());
        if (auth.isEmpty()) return  false;
        return true;
    }


    public void register(RegisterRequestDto dto){
        if (authRepository.existsByUsername(dto.getUsername()))
            throw new AuthException(ErrorType.ERROR_USERNAME);
        save(IAuthMapper.INSTANCE.toAuth(dto));
    }

}
