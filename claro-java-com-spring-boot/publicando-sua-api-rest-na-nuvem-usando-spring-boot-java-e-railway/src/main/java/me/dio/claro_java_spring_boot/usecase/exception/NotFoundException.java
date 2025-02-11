package me.dio.claro_java_spring_boot.usecase.exception;

public class NotFoundException extends BusinessException {

    public NotFoundException() {
        super("Resource not found.");
    }

}
