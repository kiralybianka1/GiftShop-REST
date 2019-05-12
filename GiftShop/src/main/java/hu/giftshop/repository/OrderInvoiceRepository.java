package hu.giftshop.repository;

import hu.giftshop.entity.OrderInvoice;
import javax.ejb.Stateless;

@Stateless
public class OrderInvoiceRepository extends BaseRepository<OrderInvoice> {
    
    public OrderInvoiceRepository() {
        super(OrderInvoice.class);
    }
}
