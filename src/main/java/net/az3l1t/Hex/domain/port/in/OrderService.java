package net.az3l1t.Hex.domain.port.in;

import net.az3l1t.Hex.application.dto.OrderRequestDto;
import net.az3l1t.Hex.application.dto.OrderResponseDto;
import net.az3l1t.Hex.domain.model.Order;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto request);
    OrderResponseDto getOrderById(Long id);
    List<OrderResponseDto> getAllOrders();
    OrderResponseDto updateOrder(Long id, OrderRequestDto request);
    void deleteOrder(Long id);
}
