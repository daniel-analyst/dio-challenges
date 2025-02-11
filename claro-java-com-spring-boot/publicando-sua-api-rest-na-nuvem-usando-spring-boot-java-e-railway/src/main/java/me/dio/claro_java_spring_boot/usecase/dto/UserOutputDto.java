package me.dio.claro_java_spring_boot.usecase.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserOutputDto {
    private Long id;
    private String name;
    private AccountOutputDto account;
    private CardOutputDto card;
    private List<FeatureOutputDto> features;
    private List<NewsOutputDto> news;
}
