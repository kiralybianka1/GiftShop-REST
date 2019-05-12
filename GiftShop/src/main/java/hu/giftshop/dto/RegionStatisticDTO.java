package hu.giftshop.dto;

import java.util.Objects;

public class RegionStatisticDTO {
    private String region;
    private Integer soldProducts;

    public RegionStatisticDTO(RegionStatisticDTOBuilder builder){
        this.region = builder.region;
        this.soldProducts = builder.soldProducts;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Integer soldProducts) {
        this.soldProducts = soldProducts;
    }

    public static class RegionStatisticDTOBuilder{
        private String region;
        private Integer soldProducts;  
        
         public RegionStatisticDTOBuilder region(String region){
            this.region = region;
            return this;
        }
        
        public RegionStatisticDTOBuilder soldProducts(Integer soldProducts){
            this.soldProducts = soldProducts;
            return this;
        }
        
        public RegionStatisticDTO build(){
            return new RegionStatisticDTO(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.region);
        hash = 17 * hash + Objects.hashCode(this.soldProducts);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegionStatisticDTO other = (RegionStatisticDTO) obj;
        if (!Objects.equals(this.region, other.region)) {
            return false;
        }
        if (!Objects.equals(this.soldProducts, other.soldProducts)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RegionStatisticDTO{" + "region=" + region + ", soldProducts=" + soldProducts + '}';
    } 
}
