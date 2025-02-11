package me.dio.claro_java_spring_boot.usecase.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateDto {
    private Long id;
    private String name;
    private AccountUpdateDto account;
    private CardUpdateDto card;
    private List<FeatureUpdateDto> features;
    private List<NewsUpdateDto> news;
}
