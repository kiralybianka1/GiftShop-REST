package hu.giftshop.controller;

import hu.giftshop.dto.OrderDTO;
import hu.giftshop.dto.OrderProductDTO;
import hu.giftshop.dto.RegionStatisticDTO;
import hu.giftshop.entity.ZipCode;
import hu.giftshop.repository.ZipCodeRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RegionStatisticController {
    
    @EJB
    private CustomerOrderController customerOrderController;
   
    @EJB
    private ZipCodeRepository zipCodeRepository;
    
    public RegionStatisticController(){

    }
    
    private String getRegionDataByZipCode(String zipCode){
        return zipCodeRepository.findRegionByZipCode(zipCode);
    }
    
    private void refreshStatistics(List<RegionStatisticDTO> regionStatistics, String region, Integer numbOfOrderProducts){
        for (int i = 0; i < regionStatistics.size(); i++) {
            if(regionStatistics.get(i).getRegion().equals(region)){
                Integer newnNumbOfOrderProducts = regionStatistics.get(i).getSoldProducts() + numbOfOrderProducts;
                regionStatistics.get(i).setSoldProducts(newnNumbOfOrderProducts);
            }
        }
        
    }
    
    private boolean containsRegionsIndex(List<RegionStatisticDTO> regionStatistics, String region){
        int i = 0;
        boolean found = false;
        while(i < regionStatistics.size() && !found){
            if(regionStatistics.get(i).getRegion().equals(region)){
                found = true;
            }
            i++;
        }
        return found;
    }
    
    public List<RegionStatisticDTO> getRegionStatistics() {
        List<RegionStatisticDTO> regionStatistics = new ArrayList<>();
        for (ZipCode zipCode : zipCodeRepository.findAll()) {
            if(!containsRegionsIndex(regionStatistics, zipCode.getRegion())){
                regionStatistics.add(new RegionStatisticDTO.RegionStatisticDTOBuilder()
                            .region(zipCode.getRegion())
                            .soldProducts(0)
                            .build()
                );
            }
        }
        
        for (OrderDTO order : customerOrderController.getOrders()) {
            String region = getRegionDataByZipCode(order.getCustomer().getAddress().getZipCode());
            Integer numbOfOrderProducts = 0;
            for (OrderProductDTO orderProduct : order.getOrderProductList()) {
                numbOfOrderProducts += orderProduct.getQuantity();
            }
            refreshStatistics(regionStatistics, region, numbOfOrderProducts);
            
        }
        return regionStatistics;
    }
    
}
