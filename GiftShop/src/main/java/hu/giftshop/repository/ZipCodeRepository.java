package hu.giftshop.repository;

import hu.giftshop.entity.ZipCode;
import javax.ejb.Stateless;

@Stateless
public class ZipCodeRepository extends BaseRepository<ZipCode> {
    
    public ZipCodeRepository(){
        super(ZipCode.class);
    }
    
    
    public String findRegionByZipCode(String zipCode){
        for (ZipCode item : findAll()) {
            if(item.getZipCode().equals(zipCode)){
                return item.getRegion();
            }
        }
        return "N.A.";
    }
    
}
