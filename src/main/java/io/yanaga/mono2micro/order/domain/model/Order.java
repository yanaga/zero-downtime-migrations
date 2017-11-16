package io.yanaga.mono2micro.order.domain.model;

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import io.yanaga.mono2micro.customer.domain.model.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private OrderNumber number;

    private OrderType orderType;

    private Long customerId;

    @ElementCollection
    private List<OrderItem> items = Lists.newArrayList();

    protected Order() {
    }

    private Order(OrderNumber number) {
        this.number = number;
    }

    public static Order of(OrderNumber number) {
        checkNotNull(number);
        return new Order(number);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("number", number)
                .add("itemSize", items.size())
                .toString();
    }

    public Order addItem(OrderItem item) {
        checkNotNull(item);
        if (!items.contains(item)) {
            items.add(item);
        }
        return this;
    }

    public BigDecimal getTotalPrice() {
        return items.stream()
                .map(OrderItem::getPrice)
                .map(orderType)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public OrderNumber getNumber() {
        return number;
    }

    public List<OrderItem> getItems() {
        return ImmutableList.copyOf(items);
    }

    public Long getId() {
        return id;
    }

    public OrderType getOrderType() {
        return orderType;
    }

}
