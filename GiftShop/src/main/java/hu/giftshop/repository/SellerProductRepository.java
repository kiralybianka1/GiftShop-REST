package hu.giftshop.repository;

import hu.giftshop.entity.SellerProduct;
import javax.ejb.Stateless;

@Stateless
public class SellerProductRepository extends BaseRepository<SellerProduct> {
    
    public SellerProductRepository() {
        super(SellerProduct.class);
    }  
}
