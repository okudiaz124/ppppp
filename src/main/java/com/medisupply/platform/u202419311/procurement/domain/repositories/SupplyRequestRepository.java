package com.medisupply.platform.u202419311.procurement.domain.repositories;

import com.medisupply.platform.u202419311.procurement.domain.model.aggregates.SupplyRequest;

/**
 * Repository contract for the supply request aggregate.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
public interface SupplyRequestRepository {
    boolean existsByRequestCode(String requestCode);
    SupplyRequest save(SupplyRequest supplyRequest);
}
