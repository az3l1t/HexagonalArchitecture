package net.az3l1t.Hex.application.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import net.az3l1t.Hex.application.dto.OrderRequestDto;
import net.az3l1t.Hex.application.dto.OrderResponseDto;
import net.az3l1t.Hex.application.mapper.OrderMapper;
import net.az3l1t.Hex.domain.model.Order;
import net.az3l1t.Hex.domain.model.OrderOutbox;
import net.az3l1t.Hex.domain.port.in.OrderService;
import net.az3l1t.Hex.domain.port.out.OrderOutboxRepository;
import net.az3l1t.Hex.domain.port.out.OrderRepository;
import net.az3l1t.Hex.infrastructure.adapter.persistence.entity.OrderType;
import net.az3l1t.Hex.infrastructure.adapter.persistence.mapper.OrderOutboxMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderOutboxRepository orderOutboxRepository;

    @Override
    @Transactional
    public OrderResponseDto createOrder(OrderRequestDto request) {
        Order savingOrder = orderMapper.toOrder(request);
        savingOrder.setCreatedAt(LocalDateTime.now());
        Order savedOne = orderRepository.save(savingOrder);

        OrderOutbox orderOutbox = OrderOutbox.builder()
                .orderId(savedOne.getId())
                .orderTypeRealTime(OrderType.NEEDS_TO_SCHEDULE.toString())
                .timesWasError(0L)
                .build();
        orderOutboxRepository.save(orderOutbox);

        return orderMapper.toDto(savingOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponseDto getOrderById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Order was not found with id : " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public OrderResponseDto updateOrder(Long id, OrderRequestDto request) {
        Order updatingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order was not found with id : " + id));
        orderMapper.updateOrder(updatingOrder, request);
        return orderMapper.toDto(updatingOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
