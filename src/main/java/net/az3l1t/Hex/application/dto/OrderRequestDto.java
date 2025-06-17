package net.az3l1t.Hex.application.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrderRequestDto(
        @NotBlank(message = "Customer name required!")
        String customerName,
        @NotNull(message = "Amount can`t be null!")
        @DecimalMin(value = "0.01", message = "Minimal amount is 0.01!")
        BigDecimal amount
) {}
