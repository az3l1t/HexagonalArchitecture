package net.az3l1t.Hex.infrastructure.adapter.persistence.repository;

import net.az3l1t.Hex.infrastructure.adapter.persistence.entity.OrderOutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaOrderOutboxRepository extends JpaRepository<OrderOutboxEntity, Long> {
}
