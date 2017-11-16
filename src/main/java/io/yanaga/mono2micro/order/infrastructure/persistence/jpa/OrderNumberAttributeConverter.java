package io.yanaga.mono2micro.order.infrastructure.persistence.jpa;

import io.yanaga.mono2micro.order.domain.model.OrderNumber;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderNumberAttributeConverter implements AttributeConverter<OrderNumber, Integer> {
    @Override
    public Integer convertToDatabaseColumn(OrderNumber attribute) {
        return attribute.toInteger();
    }

    @Override
    public OrderNumber convertToEntityAttribute(Integer dbData) {
        return OrderNumber.of(dbData);
    }

}
