package com.medisupply.platform.u202419311.procurement.domain.model.valueobjects;

import java.util.UUID;
import com.medisupply.platform.u202419311.shared.domain.DomainValidationException;

/**
 * Represents the identifier of a health facility.
 *
 * @param value facility UUID
 * @author Matthew Shinko Okuhama Diaz
 */
public record FacilityId(UUID value) {
    public FacilityId {
        if (value == null) {
            throw new DomainValidationException("facility.required", "Facility ID is required");
        }
    }
}
