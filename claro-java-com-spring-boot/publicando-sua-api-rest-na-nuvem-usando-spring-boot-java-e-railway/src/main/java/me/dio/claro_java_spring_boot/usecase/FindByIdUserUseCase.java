package me.dio.claro_java_spring_boot.usecase;

import me.dio.claro_java_spring_boot.usecase.dto.UserOutputDto;

public interface FindByIdUserUseCase {
    UserOutputDto execute(Long id);
}
