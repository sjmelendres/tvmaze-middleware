package com.tvmaze.middleware.dto;

public record ApiErrorResponse(
        int status,
        String message,
        String path
) {
}