package io.yanaga.mono2micro.customer.domain.model;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private final Long id;

    private final Name name;

    private final Surname surname;

    public CustomerDTO(Long id, Name name, Surname surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Surname getSurname() {
        return surname;
    }

}
