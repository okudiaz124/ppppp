package com.medisupply.platform.u202419311.procurement.domain.model.valueobjects;

import com.medisupply.platform.u202419311.shared.domain.DomainValidationException;

/**
 * Represents a positive quantity of supplies and its unit.
 *
 * @param quantity number of items requested
 * @param unit unit of measurement
 * @author Matthew Shinko Okuhama Diaz
 */
public record SupplyBatch(Integer quantity, String unit) {
    public SupplyBatch {
        if (quantity == null || quantity <= 0) {
            throw new DomainValidationException("batch.quantity.invalid", "Quantity must be greater than zero");
        }
        if (unit == null || unit.isBlank()) {
            throw new DomainValidationException("batch.unit.required", "Supply unit is required");
        }
    }

    /**
     * Creates a new batch by adding a positive number of units.
     *
     * @param additionalQuantity quantity to add
     * @return a new supply batch, without modifying the original
     */
    public SupplyBatch addUnits(Integer additionalQuantity) {
        // Evita cantidades inválidas y el desbordamiento de Integer.
        if (additionalQuantity == null || additionalQuantity <= 0
                || quantity > Integer.MAX_VALUE - additionalQuantity) {
            throw new DomainValidationException("batch.increment.invalid", "Invalid additional quantity");
        }
        return new SupplyBatch(quantity + additionalQuantity, unit);
    }
}
