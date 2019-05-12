package hu.giftshop.repository;

import hu.giftshop.entity.OrderProduct;
import javax.ejb.Stateless;

@Stateless
public class OrderProductRepository extends BaseRepository<OrderProduct>{

    public OrderProductRepository() {
        super(OrderProduct.class);
    }
    
    public Integer create(OrderProduct orderProduct){
        getEntityManager().persist(orderProduct);
        getEntityManager().flush();
        return orderProduct.getId();
    }
    
}
