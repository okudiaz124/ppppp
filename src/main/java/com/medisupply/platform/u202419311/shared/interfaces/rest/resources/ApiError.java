package com.medisupply.platform.u202419311.shared.interfaces.rest.resources;

/**
 * Represents a localized error message returned to the client.
 *
 * @param message explanation of the error
 * @author Matthew Shinko Okuhama Diaz
 */
public record ApiError(String message) {
}
