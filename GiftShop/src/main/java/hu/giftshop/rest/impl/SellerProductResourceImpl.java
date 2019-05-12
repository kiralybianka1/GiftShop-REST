package hu.giftshop.rest.impl;

import hu.giftshop.controller.SellerProductController;
import hu.giftshop.dto.SellerProductDTO;
import hu.giftshop.entity.SellerProduct;
import hu.giftshop.rest.ISellerProductResource;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class SellerProductResourceImpl implements ISellerProductResource{
    
    @EJB
    private SellerProductController sellerProductController;
    
     @Override
    public List<SellerProductDTO> getSellerProducts() {
        return sellerProductController.getSellerProducts();
    }

    @Override
    public SellerProductDTO getSellerProduct(int id) {
        return sellerProductController.getSellerProduct(id);
    }

    @Override
    public Response createSellerProduct(SellerProduct product) {
        sellerProductController.create(product);
        SellerProduct affectedProduct = sellerProductController.find(product.getId());
        return Response.ok(affectedProduct, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateSellerProduct(SellerProduct product) {
        sellerProductController.update(product);
        return Response.ok().build();
    }

    @Override
    public Response deleteSellerProduct(int id) {
        sellerProductController.deleteSellerProduct(id);
        return null;
    }
}
