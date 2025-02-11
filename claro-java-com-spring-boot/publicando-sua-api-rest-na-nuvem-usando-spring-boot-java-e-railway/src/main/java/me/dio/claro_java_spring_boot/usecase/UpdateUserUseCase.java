package me.dio.claro_java_spring_boot.usecase;

import me.dio.claro_java_spring_boot.usecase.dto.UserOutputDto;
import me.dio.claro_java_spring_boot.usecase.dto.UserUpdateDto;

public interface UpdateUserUseCase {
    UserOutputDto execute(UserUpdateDto userUpdateDto);
}
