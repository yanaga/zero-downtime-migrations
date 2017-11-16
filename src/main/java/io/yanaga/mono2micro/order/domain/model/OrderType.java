package io.yanaga.mono2micro.order.domain.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OrderType implements Function<BigDecimal, BigDecimal> {

    PREMIUM("P") {
        @Override
        public BigDecimal apply(BigDecimal bigDecimal) {
            return bigDecimal.multiply(new BigDecimal("0.9"));
        }
    },

    DEFAULT("D") {
        @Override
        public BigDecimal apply(BigDecimal bigDecimal) {
            return bigDecimal;
        }
    };

    private static final Map<String, OrderType> valueMap = Stream.of(values())
            .collect(Collectors.toMap(t -> t.value, t -> t));

    private final String value;

    OrderType(String value) {
        this.value = value;
    }

    public static OrderType of(String dbData) {
        return valueMap.getOrDefault(dbData, OrderType.DEFAULT);
    }

    public String toDatabaseRepresentation() {
        return value;
    }

}
