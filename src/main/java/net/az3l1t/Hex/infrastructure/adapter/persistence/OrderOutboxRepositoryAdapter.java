package net.az3l1t.Hex.infrastructure.adapter.persistence;

import lombok.RequiredArgsConstructor;
import net.az3l1t.Hex.domain.model.OrderOutbox;
import net.az3l1t.Hex.domain.port.out.OrderOutboxRepository;
import net.az3l1t.Hex.infrastructure.adapter.persistence.entity.OrderOutboxEntity;
import net.az3l1t.Hex.infrastructure.adapter.persistence.mapper.OrderOutboxMapper;
import net.az3l1t.Hex.infrastructure.adapter.persistence.repository.JpaOrderOutboxRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderOutboxRepositoryAdapter implements OrderOutboxRepository {
    private final JpaOrderOutboxRepository jpaOrderOutboxRepository;
    private final OrderOutboxMapper orderOutboxMapper;

    @Override
    @Transactional
    public OrderOutbox save(OrderOutbox orderOutbox) {
        OrderOutboxEntity savingOutbox = orderOutboxMapper.toEntity(orderOutbox);
        jpaOrderOutboxRepository.save(savingOutbox);
        return orderOutboxMapper.toDomain(savingOutbox);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<OrderOutbox> findById(Long id) {
        return jpaOrderOutboxRepository.findById(id)
                .map(orderOutboxMapper::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderOutbox> findAll() {
        return jpaOrderOutboxRepository.findAll().stream()
                .map(orderOutboxMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        jpaOrderOutboxRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return jpaOrderOutboxRepository.existsById(id);
    }
}
