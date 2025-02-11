package me.dio.claro_java_spring_boot.usecase;

import me.dio.claro_java_spring_boot.usecase.dto.UserOutputDto;

import java.util.List;

public interface FindAllUserUseCase {
    List<UserOutputDto> execute();
}
