package io.yanaga.mono2micro.customer.domain.model;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class CustomerRepository implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer save(Customer customer) {
        return entityManager.merge(customer);
    }

    public Customer findById(Long id) {
        return entityManager.find(Customer.class, id);
    }

    public List<Customer> findAll(Predicate predicate) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        return queryFactory
                .selectFrom(QCustomer.customer)
                .where(predicate)
                .from(QCustomer.customer).fetch();
    }

}
