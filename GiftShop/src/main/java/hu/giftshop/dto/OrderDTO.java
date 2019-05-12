package hu.giftshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.giftshop.entity.Customer;
import hu.giftshop.entity.OrderProduct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderDTO {
    
    private Integer id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Calendar orderDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Calendar fulfillDate;
    private Customer customer;
    private List<OrderProductDTO> orderProductList = new ArrayList<>();

    public OrderDTO(OrderDTOBuilder builder){
        this.id = builder.id;
        this.orderDate = builder.orderDate;
        this.fulfillDate = builder.fulfillDate;
        this.customer = builder.customer;
        this.orderProductList = builder.orderProductList;
    }

    public OrderDTO() {
    }  
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Calendar getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Calendar orderDate) {
        this.orderDate = orderDate;
    }

    public Calendar getFulfillDate() {
        return fulfillDate;
    }

    public void setFulfillDate(Calendar fulfillDate) {
        this.fulfillDate = fulfillDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderProductDTO> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProductDTO> orderProductList) {
        this.orderProductList = orderProductList;
    }
    
    public static class OrderDTOBuilder {
        
        private Integer id;
        private Calendar orderDate;
        private Calendar fulfillDate;
        private Customer customer;
        private List<OrderProductDTO> orderProductList = new ArrayList<>();

        public OrderDTOBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public OrderDTOBuilder orderDate(Calendar orderDate){
            this.orderDate = orderDate;
            return this;
        }
         
        public OrderDTOBuilder fulfillDate(Calendar fulfillDate){
            this.fulfillDate = fulfillDate;
            return this;
        }
          
        public OrderDTOBuilder customer(Customer customer){
            this.customer = customer;
            return this;
        }
           
        public OrderDTOBuilder orderProductList(List<OrderProduct> orderProductList){
            for(OrderProduct orderProduct : orderProductList){
                this.orderProductList.add(new OrderProductDTO.OrderProductDTOBuilder()
                                        .product(orderProduct.getProduct())
                                        .quantity(orderProduct.getQuantity())
                                        .build()
                );
            }
            return this;
        }
        
        public OrderDTO build(){
            return new OrderDTO(this);
        }
    }  
    
}
