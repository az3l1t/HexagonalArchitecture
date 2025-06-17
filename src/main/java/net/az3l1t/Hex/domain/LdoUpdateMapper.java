package net.az3l1t.Hex.domain;

import net.az3l1t.Hex.domain.model.LdoNewContent;
import net.az3l1t.Hex.domain.model.LdoNewContentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "SPRING"
)
public interface LdoUpdateMapper {
    @Mapping(target = "something", source = "something")
    @Mapping(target = "applicationInfo", source = "applicationInfo")
    @Mapping(target = "anything", source = "anything")
    LdoNewContent map(LdoNewContentRequest updates);
}
