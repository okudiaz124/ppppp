package com.medisupply.platform.u202419311.procurement.infrastructure.persistence.jpa.repositories;

import com.medisupply.platform.u202419311.procurement.infrastructure.persistence.jpa.entities.SupplyRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides database operations for supply requests.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
public interface SupplyRequestJpaRepository extends JpaRepository<SupplyRequestEntity, Long> {
    boolean existsByRequestCode(String requestCode);
}
