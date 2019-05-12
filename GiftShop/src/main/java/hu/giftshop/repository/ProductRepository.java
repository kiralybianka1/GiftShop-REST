package hu.giftshop.repository;

import hu.giftshop.entity.Product;
import javax.ejb.Stateless;

@Stateless
public class ProductRepository extends BaseRepository<Product> {
 
    public ProductRepository() {
        super(Product.class);
    }    
    
}
