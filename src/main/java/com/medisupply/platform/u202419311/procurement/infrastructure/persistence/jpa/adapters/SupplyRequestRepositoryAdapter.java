package com.medisupply.platform.u202419311.procurement.infrastructure.persistence.jpa.adapters;

import com.medisupply.platform.u202419311.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202419311.procurement.domain.repositories.SupplyRequestRepository;
import com.medisupply.platform.u202419311.procurement.infrastructure.persistence.jpa.entities.SupplyRequestEntity;
import com.medisupply.platform.u202419311.procurement.infrastructure.persistence.jpa.repositories.SupplyRequestJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Connects the domain repository with Spring Data JPA.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
@Repository
public class SupplyRequestRepositoryAdapter implements SupplyRequestRepository {
    private final SupplyRequestJpaRepository jpaRepository;

    public SupplyRequestRepositoryAdapter(SupplyRequestJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public boolean existsByRequestCode(String requestCode) {
        return jpaRepository.existsByRequestCode(requestCode);
    }

    @Override
    public SupplyRequest save(SupplyRequest request) {
        // Se guarda inmediatamente para detectar errores de código duplicado.
        SupplyRequestEntity entity = SupplyRequestEntity.fromDomain(request);
        return jpaRepository.saveAndFlush(entity).toDomain();
    }
}
