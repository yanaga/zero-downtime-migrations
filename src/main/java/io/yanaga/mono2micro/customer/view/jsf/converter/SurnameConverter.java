package io.yanaga.mono2micro.customer.view.jsf.converter;

import com.google.common.base.Strings;
import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.dsl.ComparablePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringExpression;
import io.yanaga.mono2micro.customer.domain.model.Surname;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Surname.class)
public class SurnameConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (!Strings.isNullOrEmpty(value)) {
            try {
                return Surname.of(value);
            } catch (Exception ex) {
                throw new ConverterException(String.format("Invalid Surname: %s", value));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            return value.toString();
        }
        return null;
    }

    @QueryDelegate(Surname.class)
    public static StringExpression stringValue(ComparablePath<?> path) {
        return Expressions.stringOperation(Ops.STRING_CAST, path);
    }

}
