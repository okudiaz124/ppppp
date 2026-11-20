package com.medisupply.platform.u202419311.procurement.interfaces.rest.resources;

import lombok.Getter;
import lombok.Setter;

/**
 * Defines the JSON fields accepted when creating a supply request.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
@Getter
public class CreateSupplyRequestResource {
    @Setter private String requestCode;
    @Setter private String facilityId;
    @Setter private String fulfillmentPeriodStartDate;
    @Setter private String fulfillmentPeriodEndDate;
    @Setter private Integer supplyBatchQuantity;
    @Setter private String supplyBatchUnit;
    @Setter private Integer urgencyLevel;
    @Setter private String requestNotes;

    private String status;
    private boolean statusPresent;

    /**
     * Records that the status field was supplied, even when it is null.
     *
     * @param status status received in the request
     */
    public void setStatus(String status) {
        this.status = status;
        this.statusPresent = true;
    }
}
