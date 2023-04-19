package com.emre.service;

import com.emre.dto.request.UserProfileSaveRequestDto;
import com.emre.dto.request.UserProfileUpdateRequestDto;
import com.emre.exception.ErrorType;
import com.emre.exception.UserException;
import com.emre.mapper.IUserProfileMapper;
import com.emre.rabbitmq.model.CreateUserModel;
import com.emre.repository.IUserProfileRepository;
import com.emre.repository.entity.UserProfile;
import com.emre.utility.JwtTokenManager;
import com.emre.utility.ServiceManager;
import com.emre.utility.TokenCreator;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {

    private final IUserProfileRepository userProfileRepository;

    //private final TokenCreator tokenCreator;
    private final JwtTokenManager jwtTokenManager;

    public UserProfileService(IUserProfileRepository userProfileRepository, JwtTokenManager jwtTokenManager) {
        super(userProfileRepository);
        this.userProfileRepository = userProfileRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    public void save(UserProfileSaveRequestDto dto){
        save(IUserProfileMapper.INSTANCE.toUserProfile(dto));
    }
    public void save(CreateUserModel model){
        save(IUserProfileMapper.INSTANCE.toUserProfile(model));
    }
    public void update(UserProfileUpdateRequestDto dto){
        Optional<Long> authid=jwtTokenManager.getIdFromToken(dto.getToken());
        System.out.println(authid);
        if (authid.isEmpty()){
            throw new UserException(ErrorType.ERROR_INVALID_TOKEN);
        }
        System.out.println("find öncesi");
        Optional<UserProfile> userProfile=userProfileRepository.findOptionalByAuthid(authid.get());
        System.out.println("findsonrassı");
        System.out.println(userProfile);
        if (userProfile.isPresent()){
            UserProfile profile=userProfile.get();
            profile.setAddress(dto.getAddress());
            profile.setCity(dto.getCity());
            profile.setAvatar(dto.getAvatar());
            profile.setGender(dto.getGender());
            profile.setName(dto.getName());
            profile.setPhone(dto.getPhone());
            profile.setSurname(dto.getSurname());
            update(profile);
        }
    }

    @Cacheable(value = "getnametoupper")
    public String getNameToUpper(String name){
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return name.toUpperCase();
    }

    @CacheEvict(value = "getnametoupper",allEntries = true)
    public void clearCacheToUpper(){
        System.out.println("Tüm cache i temizledim");
    }
}
