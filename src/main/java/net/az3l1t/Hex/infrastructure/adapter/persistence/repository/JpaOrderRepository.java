package net.az3l1t.Hex.infrastructure.adapter.persistence.repository;

import net.az3l1t.Hex.infrastructure.adapter.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {
}
