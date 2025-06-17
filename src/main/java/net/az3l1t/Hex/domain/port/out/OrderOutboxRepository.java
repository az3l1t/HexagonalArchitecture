package net.az3l1t.Hex.domain.port.out;

import net.az3l1t.Hex.domain.model.OrderOutbox;

import java.util.List;
import java.util.Optional;

public interface OrderOutboxRepository {
    OrderOutbox save(OrderOutbox orderOutbox);
    Optional<OrderOutbox> findById(Long id);
    List<OrderOutbox> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}
