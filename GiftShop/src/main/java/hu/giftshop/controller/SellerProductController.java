package hu.giftshop.controller;

import hu.giftshop.dto.SellerProductDTO;
import hu.giftshop.entity.SellerProduct;
import hu.giftshop.repository.BaseRepository;
import hu.giftshop.repository.SellerProductRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SellerProductController extends BaseController<SellerProduct> {
    @EJB
    private SellerProductRepository sellerProductRepository;
    
    public SellerProductController() {
        super();
    } 
    
    @Override
    protected BaseRepository<SellerProduct> getRepository() {
        return sellerProductRepository;
    }
    
    public void create(SellerProduct product) {
        sellerProductRepository.save(product);
    }
    
    public void update(SellerProduct product){
        sellerProductRepository.update(product);
    }
    
    public List<SellerProductDTO> getSellerProducts() {
        List<SellerProductDTO> productDTOList = new ArrayList<>();
        for (SellerProduct product : findAll()) {
            productDTOList.add(
                    new SellerProductDTO.SellerProductDTOBuilder()
                            .id(product.getId())
                            .name(product.getName())
                            .description(product.getDescription())
                            .price(product.getPrice())
                            .build()
            );
        }
        return productDTOList;
    }
    
    public SellerProductDTO getSellerProduct(int id){
        SellerProduct product = find(id);
        return new SellerProductDTO.SellerProductDTOBuilder()
                             .id(product.getId())
                             .name(product.getName())
                             .description(product.getDescription())
                             .price(product.getPrice())
                             .build();
    }
    
    public void deleteSellerProduct(int id){
        SellerProduct product = getRepository().find(id);
        getRepository().delete(getRepository().find(id));
    }
}
