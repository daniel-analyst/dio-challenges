package me.dio.claro_java_spring_boot.usecase.impl;

import me.dio.claro_java_spring_boot.domain.entity.*;
import me.dio.claro_java_spring_boot.domain.repository.UserRepository;
import me.dio.claro_java_spring_boot.usecase.CreateUserUseCase;
import me.dio.claro_java_spring_boot.usecase.dto.*;
import me.dio.claro_java_spring_boot.usecase.exception.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Optional.ofNullable;

@Service
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserOutputDto execute(UserCreateDto userCreateDto) {
        ofNullable(userCreateDto).orElseThrow(() -> new BusinessException("User to create must not be null."));
        ofNullable(userCreateDto.getAccount()).orElseThrow(() -> new BusinessException("User account must not be null."));
        ofNullable(userCreateDto.getCard()).orElseThrow(() -> new BusinessException("User card must not be null."));

        if (userRepository.existsByAccountNumber(userCreateDto.getAccount().getNumber())) {
            throw new BusinessException("This account number already exists.");
        }
        if (userRepository.existsByCardNumber(userCreateDto.getCard().getNumber())) {
            throw new BusinessException("This card number already exists.");
        }

        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(userCreateDto.getAccount(), accountEntity);

        CardEntity cardEntity = new CardEntity();
        BeanUtils.copyProperties(userCreateDto.getCard(), cardEntity);

        List<NewsEntity> newsEntityList = new ArrayList<>();
        for (int i = 0; i < userCreateDto.getNews().size(); i++) {
            NewsEntity newsEntity = new NewsEntity();
            BeanUtils.copyProperties(userCreateDto.getNews().get(i), newsEntity);
            newsEntityList.add(newsEntity);
        }

        List<FeatureEntity> featureEntityList = new ArrayList<>();
        for (int i = 0; i < userCreateDto.getFeatures().size(); i++) {
            FeatureEntity featureEntity = new FeatureEntity();
            BeanUtils.copyProperties(userCreateDto.getFeatures().get(i), featureEntity);
            featureEntityList.add(featureEntity);
        }

        UserEntity userEntityCreate = new UserEntity();
        userEntityCreate.setName(userCreateDto.getName());
        userEntityCreate.setAccount(accountEntity);
        userEntityCreate.setCard(cardEntity);
        userEntityCreate.setNews(newsEntityList);
        userEntityCreate.setFeatures(featureEntityList);

        UserEntity userEntity = this.userRepository.save(userEntityCreate);

        List<NewsOutputDto> newsOutputDto = userEntity.getNews().stream().map(
                newsEntity -> new NewsOutputDto(newsEntity.getId(), newsEntity.getIcon(),
                        newsEntity.getDescription())
        ).toList();

        List<FeatureOutputDto> featureOutputDto = userEntity.getFeatures().stream().map(
                featureEntity -> new FeatureOutputDto(featureEntity.getId(), featureEntity.getIcon(),
                        featureEntity.getDescription())
        ).toList();

        AccountOutputDto accountOutputDto = new AccountOutputDto();
        BeanUtils.copyProperties(userEntity.getAccount(), accountOutputDto);

        CardOutputDto cardOutputDto = new CardOutputDto();
        BeanUtils.copyProperties(userEntity.getCard(), cardOutputDto);

        UserOutputDto userOutputDto = new UserOutputDto();
        userOutputDto.setId(userEntity.getId());
        userOutputDto.setName(userEntity.getName());
        userOutputDto.setAccount(accountOutputDto);
        userOutputDto.setCard(cardOutputDto);
        userOutputDto.setNews(newsOutputDto);
        userOutputDto.setFeatures(featureOutputDto);

        return userOutputDto;
    }

}
