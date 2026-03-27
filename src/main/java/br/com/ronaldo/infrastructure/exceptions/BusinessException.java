package br.com.ronaldo.infrastructure.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}