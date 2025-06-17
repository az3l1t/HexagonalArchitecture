package net.az3l1t.Hex.domain.port.out;

import net.az3l1t.Hex.domain.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    void deleteById(Long id);
    boolean existsById(Long id);
}
