package me.dio.claro_java_spring_boot.usecase.impl;

import me.dio.claro_java_spring_boot.domain.repository.UserRepository;
import me.dio.claro_java_spring_boot.usecase.FindAllUserUseCase;
import me.dio.claro_java_spring_boot.usecase.dto.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllUserUseCaseImpl implements FindAllUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserOutputDto> execute() {
        return this.userRepository.findAll().stream().map(
                userEntity -> {
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
        ).toList();
    }
}
