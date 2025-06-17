package net.az3l1t.Hex.infrastructure.adapter.persistence.mapper;

import net.az3l1t.Hex.domain.model.OrderOutbox;
import net.az3l1t.Hex.infrastructure.adapter.persistence.entity.OrderOutboxEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderOutboxMapper {
    OrderOutbox toDomain(OrderOutboxEntity entity);
    OrderOutboxEntity toEntity(OrderOutbox orderOutbox);
}
