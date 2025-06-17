package net.az3l1t.Hex.infrastructure.adapter.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_outbox")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderOutboxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "outbox_seq")
    @SequenceGenerator(name = "outbox_seq", sequenceName = "OUTBOX_SEQ", allocationSize = 25)
    private Long outboxId;

    @Column(nullable = false, name = "order_id")
    private Long orderId;

    @Column(nullable = false, name = "order_type_real_time")
    @Enumerated(value = EnumType.STRING)
    private OrderType orderTypeRealTime;

    @Version
    @Column(nullable = false, name = "times_was_error")
    private Long timesWasError;
}
