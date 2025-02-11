package me.dio.claro_java_spring_boot.usecase.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }
}
