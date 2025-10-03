package com.enesgunumdogdu.tasks.domain.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
