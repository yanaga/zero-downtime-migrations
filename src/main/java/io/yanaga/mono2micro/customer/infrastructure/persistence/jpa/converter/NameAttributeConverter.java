package io.yanaga.mono2micro.customer.infrastructure.persistence.jpa.converter;

import io.yanaga.mono2micro.customer.domain.model.Name;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class NameAttributeConverter implements AttributeConverter<Name, String> {

    @Override
    public String convertToDatabaseColumn(Name attribute) {
        if (attribute != null) {
            return attribute.toString();
        }
        return null;
    }

    @Override
    public Name convertToEntityAttribute(String dbData) {
        if (dbData != null) {
            return Name.of(dbData);
        }
        return null;
    }
}
