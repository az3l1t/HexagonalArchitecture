package net.az3l1t.Hex.infrastructure.adapter.persistence.mapper;

import net.az3l1t.Hex.domain.model.Order;
import net.az3l1t.Hex.infrastructure.adapter.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderEntityMapper {
    OrderEntity toEntity(Order order);
    Order toDomain(OrderEntity entity);
}
