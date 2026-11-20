package com.medisupply.platform.u202419311.procurement.application.internal.commandservices;

import com.medisupply.platform.u202419311.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202419311.procurement.domain.model.aggregates.SupplyRequestStatus;
import com.medisupply.platform.u202419311.procurement.domain.model.valueobjects.*;
import com.medisupply.platform.u202419311.procurement.domain.repositories.SupplyRequestRepository;
import com.medisupply.platform.u202419311.shared.domain.DomainValidationException;
import com.medisupply.platform.u202419311.shared.domain.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.UUID;

/**
 * Handles the command to register a supply request.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
@Service
public class CreateSupplyRequestHandler {
    private final SupplyRequestRepository repository;

    public CreateSupplyRequestHandler(SupplyRequestRepository repository) {
        this.repository = repository;
    }

    /**
     * Validates the request and stores it when its code is unique.
     *
     * @param command request information
     * @return successful result or duplicate-code failure
     */
    @Transactional
    public Result<SupplyRequest> handle(CreateSupplyRequestCommand command) {
        RequestCode code = new RequestCode(command.requestCode());
        FacilityId facility = new FacilityId(parseFacilityId(command.facilityId()));
        FulfillmentPeriod period = new FulfillmentPeriod(
                parseDate(command.startDate()), parseDate(command.endDate()));
        SupplyBatch batch = new SupplyBatch(command.quantity(), command.unit());
        SupplyRequestStatus status = parseStatus(command.status(), command.statusProvided());

        // La validación de urgencia se realiza en el agregado.
        SupplyRequest request = SupplyRequest.create(
                code, facility, period, batch, command.urgencyLevel(), status, command.requestNotes());

        // El índice UNIQUE también evita registros duplicados en la base de datos.
        if (repository.existsByRequestCode(code.code())) {
            return Result.failure("request.duplicate");
        }

        return Result.success(repository.save(request));
    }

    private UUID parseFacilityId(String text) {
        if (text == null || text.isBlank()) {
            throw new DomainValidationException("facility.required", "Facility ID is required");
        }
        try {
            UUID value = UUID.fromString(text);
            if (!value.toString().equalsIgnoreCase(text)) {
                throw new IllegalArgumentException("Invalid UUID format");
            }
            return value;
        } catch (IllegalArgumentException ex) {
            throw new DomainValidationException("facility.invalid", "Facility ID must be a valid UUID");
        }
    }

    private LocalDate parseDate(String text) {
        if (text == null || text.isBlank()) {
            throw new DomainValidationException("period.required", "Both period dates are required");
        }
        try {
            return LocalDate.parse(text);
        } catch (DateTimeParseException ex) {
            throw new DomainValidationException("period.format.invalid", "Dates must use yyyy-MM-dd format");
        }
    }

    private SupplyRequestStatus parseStatus(String text, boolean statusProvided) {
        if (!statusProvided) {
            return SupplyRequestStatus.PENDING;
        }
        if (text == null) {
            throw new DomainValidationException("status.required", "Request status cannot be null");
        }
        try {
            return SupplyRequestStatus.valueOf(text);
        } catch (IllegalArgumentException ex) {
            throw new DomainValidationException("status.invalid", "Invalid request status");
        }
    }
}
