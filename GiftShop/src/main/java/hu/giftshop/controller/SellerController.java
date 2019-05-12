package hu.giftshop.controller;

import hu.giftshop.dto.SellerDTO;
import hu.giftshop.dto.SellerProductDTO;
import hu.giftshop.entity.Address;
import hu.giftshop.entity.Seller;
import hu.giftshop.entity.SellerProduct;
import hu.giftshop.repository.BaseRepository;
import hu.giftshop.repository.SellerRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SellerController extends BaseController<Seller>{

    @EJB
    private SellerRepository sellerRepository;
    
    @EJB
    private AddressController addressController;
    
    @EJB
    private SellerProductController sellerProductController;

    public SellerController() {
        super();
    }
    
    @Override
    protected BaseRepository<Seller> getRepository() {
        return sellerRepository;
    }
    
    public List<SellerDTO> getSellers(){
        List<SellerDTO> sellers = new ArrayList<>();
        for (Seller seller : findAll()) {
            sellers.add(new SellerDTO.SellerDTOBuilder()
                                     .id(seller.getId())
                                     .name(seller.getName())
                                     .phone(seller.getPhone())
                                     .email(seller.getEmail())
                                     .accountNumber(seller.getAccountNumber())
                                     .address(seller.getAddress())
                                     .build()
            );
        }
        return sellers;
    }
    
    public SellerDTO getSeller(int id){
        Seller seller = find(id);
        return new SellerDTO.SellerDTOBuilder()
                              .id(seller.getId())
                              .name(seller.getName())
                              .phone(seller.getPhone())
                              .email(seller.getEmail())
                              .address(seller.getAddress())
                              .accountNumber(seller.getAccountNumber())
                              .build();
    }
    
    public void create(Seller seller){
        Address sellersAddress = seller.getAddress();
        Address address = addressController.getAddressByAllDetails(sellersAddress);
        if(address == null){
            addressController.create(sellersAddress);
        } else {
            seller.setAddress(address);
        }
        sellerRepository.save(seller);
    }
    
    @Override
    public void update(Seller seller){
        addressController.update(seller.getAddress());
        sellerRepository.update(seller);
    }
    
    @Override
    public void delete(int id){
        Seller seller = getRepository().find(id);
        Address address = addressController.find(seller.getAddress().getId());
        getRepository().delete(seller);
    } 
    
    public List<SellerProductDTO> getSellersProducts(int id){
        List<SellerProductDTO> sellerProducts = new ArrayList<>();
        for (SellerProduct item : sellerProductController.findAll()) {
            if(item.getSeller().getId().equals(id)){
                sellerProducts.add(new SellerProductDTO.SellerProductDTOBuilder()
                                    .id(item.getId())
                                    .name(item.getName())
                                    .description(item.getDescription())
                                    .price(item.getPrice())
                                    .build()
                );
            }
        }
        return sellerProducts;
    }
    
}
