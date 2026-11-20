package com.medisupply.platform.u202419311.procurement.domain.model.valueobjects;

import java.time.LocalDate;
import com.medisupply.platform.u202419311.shared.domain.DomainValidationException;

/**
 * Defines the valid period for supplying medical materials.
 *
 * @param startDate first day of the period
 * @param endDate last day of the period
 * @author Matthew Shinko Okuhama Diaz
 */
public record FulfillmentPeriod(LocalDate startDate, LocalDate endDate) {
    public FulfillmentPeriod {
        if (startDate == null || endDate == null) {
            throw new DomainValidationException("period.required", "Both period dates are required");
        }
        if (!endDate.isAfter(startDate)) {
            throw new DomainValidationException("period.invalid", "End date must be after start date");
        }
    }

    /**
     * Checks whether a date belongs to the period, including its boundaries.
     *
     * @param checkDate date to verify
     * @return true when the date belongs to the period
     */
    public boolean contains(LocalDate checkDate) {
        if (checkDate == null) {
            throw new DomainValidationException("period.check.required", "Date to check is required");
        }
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);
    }
}
