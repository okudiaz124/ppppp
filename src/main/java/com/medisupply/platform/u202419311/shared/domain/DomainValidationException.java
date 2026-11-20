package com.medisupply.platform.u202419311.shared.domain;

/**
 * Indicates that a domain rule was not fulfilled.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
public class DomainValidationException extends IllegalArgumentException {
    private final String key;

    public DomainValidationException(String key, String message) {
        super(message);
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
