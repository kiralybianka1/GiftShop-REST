package hu.giftshop.controller;

import hu.giftshop.dto.ProductDTO;
import hu.giftshop.entity.Category;
import hu.giftshop.entity.Product;
import hu.giftshop.repository.BaseRepository;
import hu.giftshop.repository.CategoryRepository;
import hu.giftshop.repository.ProductRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.math.RoundingMode;

@Stateless
public class ProductController extends BaseController<Product> {
    
    @EJB
    private ProductRepository productRepository;

    @EJB
    private CategoryRepository categoryRepository;
    
    public ProductController() {
        super();
    } 

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }  
    
    @Override
    protected BaseRepository<Product> getRepository() {
        return productRepository;
    }
    
    public void create(Product product) {
        productRepository.save(product);
    }
    
    @Override
    public void update(Product product){
        Category category = product.getCategory();
        categoryRepository.update(category);
        productRepository.update(product);
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    public List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : findAll()) {
            productDTOList.add(
                    new ProductDTO.ProductDTOBuilder()
                            .id(product.getId())
                            .name(product.getName())
                            .description(product.getDescription())
                            .categoryName(product.getCategory())
                            .netPrice(product.getNetPrice())
                            .grossPrice (round(( (product.getNetPrice() * 1.27)),2) )
                            .grossSalePrice  (round(( product.getNetPrice() * 
                                    ((product.getCategory().getTaxRate() / 100 ) + 1) *
                                    1.27),2) )
                            .quantity(product.getQuantity())
                            .stockId(product.getStockId())
                            .build()
            );
        }
        return productDTOList;
    }
    
    public Product getProduct(int id){
        return productRepository.find(id);
    }
    
    public void deleteProduct(int id){
        Product product = getRepository().find(id);
        Category category = product.getCategory();
        category.getProductList().remove(product);
        getCategoryRepository().update(category);
        getRepository().delete(getRepository().find(id));
    }

}
