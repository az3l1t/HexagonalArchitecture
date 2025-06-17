package net.az3l1t.Hex.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderOutbox {
    private Long outboxId;

    private Long orderId;
    private String orderTypeRealTime;
    private Long timesWasError;
}
