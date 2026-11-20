package com.medisupply.platform.u202419311.procurement.domain.model.aggregates;

/**
 * Allowed states of a medical supply request.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
public enum SupplyRequestStatus {
    PENDING,
    APPROVED,
    FULFILLED,
    CANCELLED
}
