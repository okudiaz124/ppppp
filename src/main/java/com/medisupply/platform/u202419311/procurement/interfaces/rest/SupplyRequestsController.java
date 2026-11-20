package com.medisupply.platform.u202419311.procurement.interfaces.rest;

import com.medisupply.platform.u202419311.procurement.application.internal.commandservices.CreateSupplyRequestHandler;
import com.medisupply.platform.u202419311.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202419311.procurement.interfaces.rest.resources.CreateSupplyRequestResource;
import com.medisupply.platform.u202419311.procurement.interfaces.rest.transform.SupplyRequestAssembler;
import com.medisupply.platform.u202419311.shared.domain.BusinessConflictException;
import com.medisupply.platform.u202419311.shared.domain.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Exposes the endpoint for registering medical supply requests.
 *
 * @author Matthew Shinko Okuhama Diaz
 */
@RestController
@RequestMapping("/api/v1/supply-requests")
public class SupplyRequestsController {
    private final CreateSupplyRequestHandler handler;
    private final SupplyRequestAssembler assembler;

    public SupplyRequestsController(CreateSupplyRequestHandler handler,
                                    SupplyRequestAssembler assembler) {
        this.handler = handler;
        this.assembler = assembler;
    }

    /**
     * Creates a supply request.
     *
     * @param resource incoming request data
     * @return created request with status HTTP 201
     */
    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateSupplyRequestResource resource) {
        Result<SupplyRequest> result = handler.handle(assembler.toCommand(resource));

        if (!result.isSuccess()) {
            throw new BusinessConflictException(result.errorCode());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(assembler.toResource(result.value()));
    }
}
