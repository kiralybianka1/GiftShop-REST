package hu.giftshop.dto;

public class SellerProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Double price;    

    public SellerProductDTO(SellerProductDTOBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
 
    public static class SellerProductDTOBuilder {
        private Integer id;
        private String name;
        private String description;
        private Double price;
        
        public SellerProductDTOBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public SellerProductDTOBuilder name(String name){
            this.name = name;
            return this;
        }
        
        public SellerProductDTOBuilder description(String description){
            this.description = description;
            return this;
        }
        
        public SellerProductDTOBuilder price(Double price){
            this.price = price;
            return this;
        }

        public SellerProductDTO build(){
            return new SellerProductDTO(this);
        }
    }
}
