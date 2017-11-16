package io.yanaga.mono2micro.order.domain.model;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;

import static com.google.common.base.Preconditions.checkNotNull;

@Embeddable
public class OrderItem implements Serializable {

    private String product;

    private BigDecimal amount;

    private BigDecimal price;

    protected OrderItem() {
    }

    private OrderItem(String product, BigDecimal amount, BigDecimal price) {
        this.product = product;
        this.amount = amount;
        this.price = price;
    }

    public static OrderItem of(String product, BigDecimal amount, BigDecimal price) {
        checkNotNull(product);
        checkNotNull(amount);
        checkNotNull(price);
        return new OrderItem(product, amount, price);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("product", product)
                .add("amount", amount)
                .add("price", price)
                .toString();
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
