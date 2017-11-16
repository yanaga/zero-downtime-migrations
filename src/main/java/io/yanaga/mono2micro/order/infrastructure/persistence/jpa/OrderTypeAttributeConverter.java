package io.yanaga.mono2micro.order.infrastructure.persistence.jpa;

import io.yanaga.mono2micro.order.domain.model.OrderType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderTypeAttributeConverter implements AttributeConverter<OrderType, String> {
    @Override
    public String convertToDatabaseColumn(OrderType attribute) {
        return attribute.toDatabaseRepresentation();
    }

    @Override
    public OrderType convertToEntityAttribute(String dbData) {
        return OrderType.of(dbData);
    }
}
