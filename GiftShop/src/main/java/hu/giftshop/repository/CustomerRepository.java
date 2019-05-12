package hu.giftshop.repository;

import hu.giftshop.entity.Customer;
import javax.ejb.Stateless;

@Stateless
public class CustomerRepository extends BaseRepository<Customer> {

    public CustomerRepository() {
        super(Customer.class);
    }
    
}
