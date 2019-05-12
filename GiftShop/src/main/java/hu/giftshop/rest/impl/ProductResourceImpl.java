package hu.giftshop.rest.impl;

import hu.giftshop.controller.CategoryController;
import hu.giftshop.controller.ProductController;
import hu.giftshop.dto.ProductDTO;
import hu.giftshop.entity.Product;
import hu.giftshop.rest.IProductResource;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class ProductResourceImpl implements IProductResource {
    
    @EJB
    private ProductController productController;
    
    @EJB
    private CategoryController categoryController;
    
    @Override
    public List<ProductDTO> getProducts() {
        return productController.getProducts();
    }
    
    @Override
    public Product getProduct(int id) {
        return productController.getProduct(id);
    }

    @Override
    public Response createProduct(Product product) {
        productController.create(product);
        Product affectedProduct = productController.find(product.getId());
        return Response.ok(affectedProduct, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateProduct(Product product) {
        productController.update(product);
        return Response.ok().build();
    }

    @Override
    public Response deleteProduct(int id) {
        productController.deleteProduct(id);
        return null;
    }
    
}
