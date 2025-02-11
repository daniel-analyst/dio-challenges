package me.dio.claro_java_spring_boot.usecase.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateDto {

    private String name;

    private AccountCreateDto account;

    private CardCreateDto card;

    private List<FeatureCreateDto> features;

    private List<NewsCreateDto> news;
}
