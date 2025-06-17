package net.az3l1t.Hex.infrastructure.adapter.persistence;

import lombok.RequiredArgsConstructor;
import net.az3l1t.Hex.domain.model.Order;
import net.az3l1t.Hex.domain.port.out.OrderRepository;
import net.az3l1t.Hex.infrastructure.adapter.persistence.entity.OrderEntity;
import net.az3l1t.Hex.infrastructure.adapter.persistence.mapper.OrderEntityMapper;
import net.az3l1t.Hex.infrastructure.adapter.persistence.repository.JpaOrderRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {
    private final JpaOrderRepository jpaOrderRepository;
    private final OrderEntityMapper orderEntityMapper;

    @Override
    @Transactional
    public Order save(Order order) {
        OrderEntity orderEntity = orderEntityMapper.toEntity(order);
        jpaOrderRepository.save(orderEntity);
        return orderEntityMapper.toDomain(orderEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> findById(Long id) {
        return jpaOrderRepository.findById(id)
                .map(orderEntityMapper::toDomain);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return jpaOrderRepository.findAll()
                .stream()
                .map(orderEntityMapper::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        jpaOrderRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return jpaOrderRepository.existsById(id);
    }
}
