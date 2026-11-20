package com.medisupply.platform.u202419311.procurement.domain.model.aggregates;

import com.medisupply.platform.u202419311.procurement.domain.model.valueobjects.*;
import com.medisupply.platform.u202419311.shared.domain.DomainValidationException;
import java.time.Instant;

/**
 * Aggregate root for a medical supply request.
 *
 * @param id generated database identifier
 * @param requestCode unique code of the request
 * @param facilityId requesting health facility
 * @param fulfillmentPeriod period to fulfill the request
 * @param supplyBatch quantity and unit of supplies
 * @param urgencyLevel urgency from one to five
 * @param status request status
 * @param requestNotes optional notes
 * @param createdAt creation time
 * @param updatedAt last update time
 * @author Matthew Shinko Okuhama Diaz
 */
public record SupplyRequest(
        Long id,
        RequestCode requestCode,
        FacilityId facilityId,
        FulfillmentPeriod fulfillmentPeriod,
        SupplyBatch supplyBatch,
        Integer urgencyLevel,
        SupplyRequestStatus status,
        String requestNotes,
        Instant createdAt,
        Instant updatedAt) {

    public SupplyRequest {
        if (requestCode == null || facilityId == null || fulfillmentPeriod == null || supplyBatch == null) {
            throw new DomainValidationException("request.fields.required", "Required request fields are missing");
        }
        if (urgencyLevel == null || urgencyLevel < 1 || urgencyLevel > 5) {
            throw new DomainValidationException("request.urgency.invalid", "Urgency level must be between 1 and 5");
        }
        if (status == null) {
            throw new DomainValidationException("status.required", "Request status is required");
        }
        if (createdAt == null || updatedAt == null) {
            throw new DomainValidationException("request.audit.required", "Audit dates are required");
        }
    }

    /**
     * Creates a new request with matching audit timestamps.
     *
     * @param requestCode unique request code
     * @param facilityId facility identifier
     * @param period requested period
     * @param batch supply batch
     * @param urgencyLevel urgency from one to five
     * @param status initial status
     * @param notes optional notes
     * @return new request without an assigned ID
     */
    public static SupplyRequest create(RequestCode requestCode, FacilityId facilityId,
                                       FulfillmentPeriod period, SupplyBatch batch,
                                       Integer urgencyLevel, SupplyRequestStatus status, String notes) {
        Instant now = Instant.now();
        return new SupplyRequest(null, requestCode, facilityId, period, batch,
                urgencyLevel, status, notes, now, now);
    }

    public SupplyRequest withId(Long newId) {
        return new SupplyRequest(newId, requestCode, facilityId, fulfillmentPeriod,
                supplyBatch, urgencyLevel, status, requestNotes, createdAt, updatedAt);
    }
}
