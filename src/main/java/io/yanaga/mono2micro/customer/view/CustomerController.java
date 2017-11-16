package io.yanaga.mono2micro.customer.view;

import io.yanaga.mono2micro.customer.domain.model.Customer;
import io.yanaga.mono2micro.customer.domain.model.CustomerRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CustomerController implements Serializable {

    @Inject
    private CustomerRepository customerRepository;

    private CustomerForm form = CustomerForm.of();

    private Customer customer = Customer.of();

    public List<Customer> findAll() {
        return customerRepository.findAll(form.toPredicate());
    }

    public String save() {
        customerRepository.save(customer);
        return "list.xhtml?faces-redirect=true";
    }

    public String create() {
        this.customer = Customer.of();
        return "edit.xhtml?faces-redirect=true";
    }

    public String edit(Customer customer) {
        this.customer = customer;
        return "edit.xhtml?faces-redirect=true";
    }

    public CustomerForm getForm() {
        return form;
    }

    public Customer getCustomer() {
        return customer;
    }

}
