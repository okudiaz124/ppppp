package com.medisupply.platform.u202419311.procurement.interfaces.rest.transform;

import com.medisupply.platform.u202419311.procurement.application.internal.commandservices.CreateSupplyRequestCommand;
import com.medisupply.platform.u202419311.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202419311.procurement.interfaces.rest.resources.CreateSupplyRequestResource;
import com.medisupply.platform.u202419311.procurement.interfaces.rest.resources.SupplyRequestResource;
import org.springframework.stereotype.Component;

/**
 * Converts HTTP resources into commands and domain results into responses.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
@Component
public class SupplyRequestAssembler {
    public CreateSupplyRequestCommand toCommand(CreateSupplyRequestResource resource) {
        return new CreateSupplyRequestCommand(
                resource.getRequestCode(),
                resource.getFacilityId(),
                resource.getFulfillmentPeriodStartDate(),
                resource.getFulfillmentPeriodEndDate(),
                resource.getSupplyBatchQuantity(),
                resource.getSupplyBatchUnit(),
                resource.getUrgencyLevel(),
                resource.getStatus(),
                resource.isStatusPresent(),
                resource.getRequestNotes());
    }

    public SupplyRequestResource toResource(SupplyRequest request) {
        return new SupplyRequestResource(
                request.id(),
                request.requestCode().code(),
                request.facilityId().value().toString(),
                request.fulfillmentPeriod().startDate().toString(),
                request.fulfillmentPeriod().endDate().toString(),
                request.supplyBatch().quantity(),
                request.supplyBatch().unit(),
                request.urgencyLevel(),
                request.status().name(),
                request.requestNotes());
    }
}
