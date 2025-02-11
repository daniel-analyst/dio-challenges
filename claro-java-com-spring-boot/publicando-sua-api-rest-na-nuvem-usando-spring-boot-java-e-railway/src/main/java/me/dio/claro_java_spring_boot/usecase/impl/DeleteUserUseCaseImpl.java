package me.dio.claro_java_spring_boot.usecase.impl;

import me.dio.claro_java_spring_boot.domain.entity.UserEntity;
import me.dio.claro_java_spring_boot.domain.repository.UserRepository;
import me.dio.claro_java_spring_boot.usecase.DeleteUserUseCase;
import me.dio.claro_java_spring_boot.usecase.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUseCaseImpl implements DeleteUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void execute(Long id) {
        UserEntity dbUser = userRepository.findById(id).orElseThrow(NotFoundException::new);
        this.userRepository.delete(dbUser);
    }
}
