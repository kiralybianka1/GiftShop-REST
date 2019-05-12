package hu.giftshop.rest.impl;

import hu.giftshop.controller.CategoryController;
import hu.giftshop.entity.Category;
import hu.giftshop.rest.ICategoryResource;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class CategoryResourceImpl implements ICategoryResource {

    @EJB
    private CategoryController categoryController;
    
    @Override
    public List<Category> getCategories() {
        return categoryController.findAll();
    }

    @Override
    public Category getCategory(int id) {
        return categoryController.find(id);
    }

    @Override
    public Response createCategory(Category category) {
        categoryController.create(category);
        return Response.ok().build();
    }

    @Override
    public Response updateCategory(Category category) {
        categoryController.update(category);
        Category entity = categoryController.find(category.getId());
        return Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteCategory(int id) {
        categoryController.delete(id);
        return Response.ok().build();
    }
      
}
