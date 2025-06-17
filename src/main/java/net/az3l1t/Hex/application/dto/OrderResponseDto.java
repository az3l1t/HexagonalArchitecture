package net.az3l1t.Hex.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponseDto(
        Long id,
        String customerName,
        BigDecimal amount,
        LocalDateTime createdAt
) {}
