package me.dio.claro_java_spring_boot.usecase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewsOutputDto {
    private Long id;
    private String icon;
    private String description;
}
