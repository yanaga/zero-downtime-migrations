package io.yanaga.mono2micro.customer.view;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import io.yanaga.mono2micro.customer.domain.model.QCustomer;
import me.yanaga.querydsl.args.core.single.SingleStringArgument;

import java.io.Serializable;

public class CustomerForm implements Serializable {

    private SingleStringArgument name = SingleStringArgument.of();

    private SingleStringArgument surname = SingleStringArgument.of();

    private CustomerForm() {
    }

    public static CustomerForm of() {
        return new CustomerForm();
    }

    public Predicate toPredicate() {
        BooleanBuilder builder = new BooleanBuilder();
        name.append(builder, QCustomer.customer.name.stringValue());
        surname.append(builder, QCustomer.customer.surname.stringValue());
        return builder;
    }

    public SingleStringArgument getName() {
        return name;
    }

    public void setName(SingleStringArgument name) {
        this.name = name;
    }

    public SingleStringArgument getSurname() {
        return surname;
    }

    public void setSurname(SingleStringArgument surname) {
        this.surname = surname;
    }
}
