package com.tvmaze.middleware.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateCommentRequest(

        @NotNull(message = "El campo 'show_id' es obligatorio")
        @JsonProperty("show_id")
        Long showId,

        @NotBlank(message = "El campo 'comment' es obligatorio")
        String comment,

        @NotNull(message = "El campo 'rating' es obligatorio")
        @Min(value = 0, message = "El campo 'rating' debe estar entre 0 y 5")
        @Max(value = 5, message = "El campo 'rating' debe estar entre 0 y 5")
        Integer rating
) {}