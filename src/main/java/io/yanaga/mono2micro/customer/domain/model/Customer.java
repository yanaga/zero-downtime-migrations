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

    private Surname lastname;

    @PrePersist
    @PreUpdate
    void prePersist() {
        this.surname = lastname;
    }

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
        return lastname;
    }

    public void setSurname(Surname lastname) {
        this.lastname = lastname;
        this.surname = lastname;
    }

}
