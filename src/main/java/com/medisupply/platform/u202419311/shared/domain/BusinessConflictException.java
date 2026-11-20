package com.medisupply.platform.u202419311.shared.domain;

/**
 * Indicates a conflict with an existing business record.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
public class BusinessConflictException extends RuntimeException {
    public BusinessConflictException(String errorCode) {
        super(errorCode);
    }
}
