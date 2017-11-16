package io.yanaga.mono2micro.customer.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Name name;

    private Surname surname;

    protected Customer() {
    }

    public static Customer of() {
        return new Customer();
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Surname getSurname() {
        return surname;
    }

    public void setSurname(Surname surname) {
        this.surname = surname;
    }

}
