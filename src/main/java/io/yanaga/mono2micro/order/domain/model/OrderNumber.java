package io.yanaga.mono2micro.order.domain.model;

import java.io.Serializable;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class OrderNumber implements Serializable, Formattable {

    private final Integer value;

    private OrderNumber(Integer value) {
        this.value = value;
    }

    public static OrderNumber of(Integer value) {
        checkNotNull(value);
        checkArgument(value > 1000, "value.greater.thousand");
        return new OrderNumber(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof OrderNumber) {
            OrderNumber other = (OrderNumber) obj;
            return Objects.equals(this.value, other.value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("%d", value);
    }

    public Integer toInteger() {
        return value;
    }

}

