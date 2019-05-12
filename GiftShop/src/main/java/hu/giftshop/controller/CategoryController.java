package hu.giftshop.controller;

import hu.giftshop.entity.Category;
import hu.giftshop.repository.BaseRepository;
import hu.giftshop.repository.CategoryRepository;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CategoryController extends BaseController<Category>{

    @EJB
    private CategoryRepository categoryRepository;
    
    public CategoryController() {
        super();
    }
    
    @Override
    protected BaseRepository<Category> getRepository() {
        return categoryRepository;
    }
    
    public void create(Category category) {
        categoryRepository.save(category);
    }
    
    public Category getCategory(int id){
        return categoryRepository.find(id);
    }
    
}
