package me.dio.claro_java_spring_boot.usecase.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class CardUpdateDto {
    private Long id;
    private String number;
    private BigDecimal limit;
}
