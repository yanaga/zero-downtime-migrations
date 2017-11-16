package io.yanaga.mono2micro.order.view.jsf;

import io.yanaga.mono2micro.order.domain.model.OrderNumber;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = OrderNumber.class)
public class OrderNumberFacesConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        }
        try {
            int intValue = Integer.parseInt(value);
            return OrderNumber.of(intValue);
        } catch (NumberFormatException ex) {
            throw new FacesException("Invalid Order Number");
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return null;
        }
        OrderNumber orderNumber = (OrderNumber) value;
        return String.format("%s", orderNumber);
    }

}
