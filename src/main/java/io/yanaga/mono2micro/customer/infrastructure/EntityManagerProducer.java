package io.yanaga.mono2micro.customer.infrastructure;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EntityManagerProducer {

    @Produces
    @Dependent
    @PersistenceContext
    public EntityManager entityManager;

}
