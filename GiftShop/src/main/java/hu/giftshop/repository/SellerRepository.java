package hu.giftshop.repository;

import hu.giftshop.entity.Seller;
import javax.ejb.Stateless;

@Stateless
public class SellerRepository extends BaseRepository<Seller>{

    public SellerRepository() {
        super(Seller.class);
    }
    
}
