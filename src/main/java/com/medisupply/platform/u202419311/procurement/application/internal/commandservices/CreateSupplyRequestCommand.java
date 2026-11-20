package com.medisupply.platform.u202419311.procurement.application.internal.commandservices;

/**
 * Input values required to create a supply request.
 *
 * @param requestCode unique request code
 * @param facilityId facility UUID in text form
 * @param startDate start date in ISO format
 * @param endDate end date in ISO format
 * @param quantity requested quantity
 * @param unit unit of measurement
 * @param urgencyLevel urgency between one and five
 * @param status initial status, when supplied
 * @param statusProvided indicates if status was present in the JSON
 * @param requestNotes optional notes
 * @author Matthew Shinko Okuhama Diaz
 */
public record CreateSupplyRequestCommand(
        String requestCode,
        String facilityId,
        String startDate,
        String endDate,
        Integer quantity,
        String unit,
        Integer urgencyLevel,
        String status,
        boolean statusProvided,
        String requestNotes) {
}
