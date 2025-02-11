package me.dio.claro_java_spring_boot.usecase;

import me.dio.claro_java_spring_boot.usecase.dto.UserCreateDto;
import me.dio.claro_java_spring_boot.usecase.dto.UserOutputDto;

public interface CreateUserUseCase {
    UserOutputDto execute(UserCreateDto userCreateDto);
}
