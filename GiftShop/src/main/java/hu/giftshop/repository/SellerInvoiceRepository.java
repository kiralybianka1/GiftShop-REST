package hu.giftshop.repository;

import hu.giftshop.entity.SellerInvoice;
import javax.ejb.Stateless;

@Stateless
public class SellerInvoiceRepository extends BaseRepository<SellerInvoice>{
    
     public SellerInvoiceRepository(){
        super(SellerInvoice.class);
    }
}
