package net.az3l1t.Hex.application.mapper;

import net.az3l1t.Hex.application.dto.OrderRequestDto;
import net.az3l1t.Hex.application.dto.OrderResponseDto;
import net.az3l1t.Hex.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    Order toOrder(OrderRequestDto orderRequestDto);
    
    OrderResponseDto toDto(Order order);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateOrder(@MappingTarget Order order, OrderRequestDto orderRequestDto);
}
