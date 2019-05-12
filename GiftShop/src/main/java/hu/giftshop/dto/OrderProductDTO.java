package hu.giftshop.dto;

import hu.giftshop.entity.Product;

public class OrderProductDTO {
    private Product product;
    private Integer quantity;

    public OrderProductDTO(OrderProductDTOBuilder builder) {
        this.product = builder.product;
        this.quantity = builder.quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public static class OrderProductDTOBuilder {
        private Product product;
        private Integer quantity;
        
        public OrderProductDTOBuilder product(Product product){
            this.product = product;
            return this;
        }
        
        public OrderProductDTOBuilder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }
        
        public OrderProductDTO build(){
            return new OrderProductDTO(this);
        }
    }
}
