package hu.giftshop.rest.impl;

import hu.giftshop.controller.AddressController;
import hu.giftshop.controller.SellerController;
import hu.giftshop.dto.SellerDTO;
import hu.giftshop.dto.SellerProductDTO;
import hu.giftshop.entity.Address;
import hu.giftshop.entity.Seller;
import hu.giftshop.rest.ISellerResource;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class SellerResourceImpl implements ISellerResource {

    @EJB
    private SellerController sellerController;
    
    @EJB
    private AddressController addressController;
    
    @Override
    public List<SellerDTO> getSellers() {
        return sellerController.getSellers();
    }

    @Override
    public SellerDTO getSellerById(int id) {
        return sellerController.getSeller(id);
    }

    @Override
    public Response createSeller(Seller seller) {
        sellerController.create(seller);
        Seller affectedEntity = sellerController.find(seller.getId());
        return Response.ok(affectedEntity, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateSeller(Seller seller) {
        sellerController.update(seller);
        Seller affectedEntity = sellerController.find(seller.getId());
        return Response.ok(this, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteSeller(int id) {
        Seller seller = sellerController.find(id);
        Address address = addressController.find(seller.getAddress().getId());
        sellerController.delete(id);
        return Response.ok().build();
    }

    @Override
    public List<SellerProductDTO> getSellersProducts(int id) {
        return sellerController.getSellersProducts(id);
    }
}
