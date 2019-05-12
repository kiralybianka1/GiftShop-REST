package hu.giftshop.repository;

import hu.giftshop.entity.CustomerOrder;
import javax.ejb.Stateless;

@Stateless
public class CustomerOrderRepository extends BaseRepository<CustomerOrder>{ 

    public CustomerOrderRepository() {
        super(CustomerOrder.class);
    }
    
    public Integer createCustomerOrder(CustomerOrder customerOrder) {
        getEntityManager().persist(customerOrder);
        getEntityManager().flush();
        System.out.println("ENTITY MANAGER FLUSHED");
        Integer id = customerOrder.getId();
        System.out.println("INSERTED ID: " + id.toString());
        return id;
    }
}
