package com.medisupply.platform.u202419311.shared.domain;

/**
 * Represents either a successful operation or a business failure.
 *
 * @param value result of a successful operation
 * @param errorCode code of a business failure
 * @param <T> type of the returned value
 * @author Matthew Shinko Okuhama Diaz
 */
public record Result<T>(T value, String errorCode) {
    public static <T> Result<T> success(T value) {
        return new Result<>(value, null);
    }

    public static <T> Result<T> failure(String errorCode) {
        return new Result<>(null, errorCode);
    }

    public boolean isSuccess() {
        return errorCode == null;
    }
}
