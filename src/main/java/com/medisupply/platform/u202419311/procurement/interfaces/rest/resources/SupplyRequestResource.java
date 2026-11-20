package com.medisupply.platform.u202419311.procurement.interfaces.rest.resources;

/**
 * Defines the JSON response returned after registering a request.
 *
 * @param id generated identifier
 * @param requestCode request code
 * @param facilityId facility UUID
 * @param fulfillmentPeriodStartDate first date in ISO format
 * @param fulfillmentPeriodEndDate last date in ISO format
 * @param supplyBatchQuantity requested quantity
 * @param supplyBatchUnit requested unit
 * @param urgencyLevel urgency value
 * @param status request state
 * @param requestNotes optional notes
 * @author Matthew Shinko Okuhama Diaz
 */
public record SupplyRequestResource(
        Long id,
        String requestCode,
        String facilityId,
        String fulfillmentPeriodStartDate,
        String fulfillmentPeriodEndDate,
        Integer supplyBatchQuantity,
        String supplyBatchUnit,
        Integer urgencyLevel,
        String status,
        String requestNotes) {
}
