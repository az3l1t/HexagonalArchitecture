package net.az3l1t.Hex.infrastructure.adapter.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import net.az3l1t.Hex.application.dto.OrderRequestDto;
import net.az3l1t.Hex.application.dto.OrderResponseDto;
import net.az3l1t.Hex.domain.port.in.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderResponseDto createOrder(@Valid @RequestBody OrderRequestDto request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/{id}")
    public OrderResponseDto getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/{id}")
    public OrderResponseDto updateOrder(@PathVariable Long id,
                             @Valid @RequestBody OrderRequestDto request) {
        return orderService.updateOrder(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
