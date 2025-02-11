package me.dio.claro_java_spring_boot.usecase.impl;

import me.dio.claro_java_spring_boot.domain.entity.*;
import me.dio.claro_java_spring_boot.domain.repository.UserRepository;
import me.dio.claro_java_spring_boot.usecase.UpdateUserUseCase;
import me.dio.claro_java_spring_boot.usecase.dto.*;
import me.dio.claro_java_spring_boot.usecase.exception.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UpdateUserUseCaseImpl implements UpdateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserOutputDto execute(UserUpdateDto userUpdateDto) {
        this.userRepository.findById(userUpdateDto.getId()).orElseThrow(NotFoundException::new);

        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(userUpdateDto.getAccount(), accountEntity);

        CardEntity cardEntity = new CardEntity();
        BeanUtils.copyProperties(userUpdateDto.getCard(), cardEntity);

        List<NewsEntity> newsEntityList = new ArrayList<>();
        for (int i = 0; i < userUpdateDto.getNews().size(); i++) {
            NewsEntity newsEntity = new NewsEntity();
            BeanUtils.copyProperties(userUpdateDto.getNews().get(i), newsEntity);
            newsEntityList.add(newsEntity);
        }

        List<FeatureEntity> featureEntityList = new ArrayList<>();
        for (int i = 0; i < userUpdateDto.getFeatures().size(); i++) {
            FeatureEntity featureEntity = new FeatureEntity();
            BeanUtils.copyProperties(userUpdateDto.getFeatures().get(i), featureEntity);
            featureEntityList.add(featureEntity);
        }

        UserEntity userEntityUpdate = new UserEntity();
        userEntityUpdate.setId(userUpdateDto.getId());
        userEntityUpdate.setName(userUpdateDto.getName());
        userEntityUpdate.setAccount(accountEntity);
        userEntityUpdate.setCard(cardEntity);
        userEntityUpdate.setNews(newsEntityList);
        userEntityUpdate.setFeatures(featureEntityList);

        UserEntity userEntity = this.userRepository.save(userEntityUpdate);

        AccountOutputDto accountOutputDto = new AccountOutputDto();
        BeanUtils.copyProperties(userEntity.getAccount(), accountOutputDto);

        CardOutputDto cardOutputDto = new CardOutputDto();
        BeanUtils.copyProperties(userEntity.getCard(), cardOutputDto);

        List<NewsOutputDto> newsOutputDtoList = new ArrayList<>();
        for (int i = 0; i < userUpdateDto.getNews().size(); i++) {
            NewsOutputDto newsOutputDto = new NewsOutputDto();
            BeanUtils.copyProperties(userEntity.getNews().get(i), newsOutputDto);
            newsOutputDtoList.add(newsOutputDto);
        }

        List<FeatureOutputDto> featureOutputDtoList = new ArrayList<>();
        for (int i = 0; i < userUpdateDto.getFeatures().size(); i++) {
            FeatureOutputDto featureOutputDto = new FeatureOutputDto();
            BeanUtils.copyProperties(userEntity.getFeatures().get(i), featureOutputDto);
            featureOutputDtoList.add(featureOutputDto);
        }

        UserOutputDto userOutputDto = new UserOutputDto();
        userOutputDto.setId(userEntity.getId());
        userOutputDto.setName(userEntity.getName());
        userOutputDto.setAccount(accountOutputDto);
        userOutputDto.setCard(cardOutputDto);
        userOutputDto.setNews(newsOutputDtoList);
        userOutputDto.setFeatures(featureOutputDtoList);

        return userOutputDto;
    }
}
