package me.dio.claro_java_spring_boot.usecase.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountOutputDto {
    private Long id;
    private String number;
    private String agency;
    private BigDecimal balance;
    private BigDecimal limit;
}
