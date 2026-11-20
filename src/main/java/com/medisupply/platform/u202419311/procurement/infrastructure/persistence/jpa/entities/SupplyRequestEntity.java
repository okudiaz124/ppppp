package com.medisupply.platform.u202419311.procurement.infrastructure.persistence.jpa.entities;

import com.medisupply.platform.u202419311.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202419311.procurement.domain.model.aggregates.SupplyRequestStatus;
import com.medisupply.platform.u202419311.procurement.domain.model.valueobjects.*;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

/**
 * JPA entity used to store requests in the supply_requests table.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
@Entity
@Table(name = "supply_requests",
        uniqueConstraints = @UniqueConstraint(name = "uk_supply_requests_request_code", columnNames = "request_code"))
public class SupplyRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "request_code", nullable = false, unique = true)
    private String requestCode;

    @Column(name = "facility_id", nullable = false, length = 36)
    private String facilityId;

    @Column(name = "fulfillment_period_start_date", nullable = false)
    private LocalDate fulfillmentPeriodStartDate;

    @Column(name = "fulfillment_period_end_date", nullable = false)
    private LocalDate fulfillmentPeriodEndDate;

    @Column(name = "supply_batch_quantity", nullable = false)
    private Integer supplyBatchQuantity;

    @Column(name = "supply_batch_unit", nullable = false)
    private String supplyBatchUnit;

    @Column(name = "urgency_level", nullable = false)
    private Integer urgencyLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private SupplyRequestStatus status;

    @Column(name = "request_notes", length = 2000)
    private String requestNotes;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    protected SupplyRequestEntity() {
    }

    /**
     * Maps the domain aggregate to a database entity.
     *
     * @param request aggregate to persist
     * @return mapped JPA entity
     */
    public static SupplyRequestEntity fromDomain(SupplyRequest request) {
        SupplyRequestEntity entity = new SupplyRequestEntity();
        entity.id = request.id();
        entity.requestCode = request.requestCode().code();
        entity.facilityId = request.facilityId().value().toString();
        entity.fulfillmentPeriodStartDate = request.fulfillmentPeriod().startDate();
        entity.fulfillmentPeriodEndDate = request.fulfillmentPeriod().endDate();
        entity.supplyBatchQuantity = request.supplyBatch().quantity();
        entity.supplyBatchUnit = request.supplyBatch().unit();
        entity.urgencyLevel = request.urgencyLevel();
        entity.status = request.status();
        entity.requestNotes = request.requestNotes();
        entity.createdAt = request.createdAt();
        entity.updatedAt = request.updatedAt();
        return entity;
    }

    /**
     * Reconstructs the domain aggregate from the stored data.
     *
     * @return aggregate with its generated identifier
     */
    public SupplyRequest toDomain() {
        return new SupplyRequest(id,
                new RequestCode(requestCode),
                new FacilityId(UUID.fromString(facilityId)),
                new FulfillmentPeriod(fulfillmentPeriodStartDate, fulfillmentPeriodEndDate),
                new SupplyBatch(supplyBatchQuantity, supplyBatchUnit),
                urgencyLevel, status, requestNotes, createdAt, updatedAt);
    }
}
