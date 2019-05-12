package hu.giftshop.repository;

import hu.giftshop.entity.Category;
import javax.ejb.Stateless;

@Stateless
public class CategoryRepository extends BaseRepository<Category> { 
    
    public CategoryRepository() {
        super(Category.class);
    }
       
}
