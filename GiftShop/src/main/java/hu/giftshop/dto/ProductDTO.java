package hu.giftshop.dto;

import hu.giftshop.entity.Category;

public class ProductDTO {

    private Integer id;
    private String name;
    private String description;
    private Double grossPrice;
    private Double grossSalePrice;
    private Double netPrice;    
    private Category category;
    private Integer quantity;
    private Integer stockId; 

    public ProductDTO(ProductDTOBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
        this.category = builder.category;
        this.netPrice = builder.netPrice;
        this.grossPrice = builder.grossPrice;
        this.grossSalePrice = builder.grossSalePrice;
        this.quantity = builder.quantity;
        this.stockId = builder.stockId;
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

    public Double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(Double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public Double getGrossSalePrice() {
        return grossSalePrice;
    }

    public void setGrossSalePrice(Double grossSalePrice) {
        this.grossSalePrice = grossSalePrice;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }  
    
    public static class ProductDTOBuilder {
        private Integer id;
        private String name;
        private String description;
        private Double grossPrice;
        private Double grossSalePrice;
        private Double netPrice;  
        private Category category;
        private Integer quantity;
        private Integer stockId;
        
        public ProductDTOBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public ProductDTOBuilder name(String name){
            this.name = name;
            return this;
        }
        
        public ProductDTOBuilder description(String description){
            this.description = description;
            return this;
        }

        public ProductDTOBuilder categoryName(Category category){
            this.category = category;
            return this;
        }
        
        public ProductDTOBuilder netPrice(Double price){
            this.netPrice = price;
            return this;
        }
        
        public ProductDTOBuilder grossPrice(Double price){
            this.grossPrice = price;
            return this;
        }
        
        public ProductDTOBuilder grossSalePrice(Double price){
            this.grossSalePrice = price;
            return this;
        }
        
        public ProductDTOBuilder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }
        
        public ProductDTOBuilder stockId(Integer stockId){
            this.stockId = stockId;
            return this;
        }
        
        public ProductDTO build(){
            return new ProductDTO(this);
        }
          
    }

}
