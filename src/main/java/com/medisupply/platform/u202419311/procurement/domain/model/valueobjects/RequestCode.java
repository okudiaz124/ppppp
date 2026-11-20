package com.medisupply.platform.u202419311.procurement.domain.model.valueobjects;

import com.medisupply.platform.u202419311.shared.domain.DomainValidationException;

/**
 * Identifies a supply request using a non-empty code.
 *
 * @param code unique request code
 * @author Matthew Shinko Okuhama Diaz
 */
public record RequestCode(String code) {
    public RequestCode {
        // El código de la solicitud es obligatorio.
        if (code == null || code.isBlank()) {
            throw new DomainValidationException("request.code.required", "Request code is required");
        }
    }
}
