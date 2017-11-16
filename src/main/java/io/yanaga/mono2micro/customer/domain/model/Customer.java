package io.yanaga.mono2micro.customer.domain.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Name name;

    private Surname lastname;

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

    public Surname getLastname() {
        return lastname;
    }

    public void setLastname(Surname lastname) {
        this.lastname = lastname;
    }

}
