package io.yanaga.mono2micro.customer.infrastructure.persistence.jpa.converter;

import io.yanaga.mono2micro.customer.domain.model.Surname;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class SurnameAttributeConverter implements AttributeConverter<Surname, String> {

    @Override
    public String convertToDatabaseColumn(Surname attribute) {
        if (attribute != null) {
            return attribute.toString();
        }
        return null;
    }

    @Override
    public Surname convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            return Surname.of(dbData);
        }
        return null;
    }
}
