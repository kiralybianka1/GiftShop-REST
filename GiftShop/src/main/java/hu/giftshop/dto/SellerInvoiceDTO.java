package hu.giftshop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import hu.giftshop.entity.Seller;
import java.util.Calendar;

public class SellerInvoiceDTO {
    private Integer id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Calendar invoiceDate;
    private Double totalPrice;    
    private Seller seller;

    private SellerInvoiceDTO(SellerInvoiceDTOBuilder builder) {
        this.id = builder.id;
        this.invoiceDate = builder.invoiceDate;
        this.totalPrice = builder.totalPrice;
        this.seller = builder.seller;
    }
    
     public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Calendar invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
    
    public static class SellerInvoiceDTOBuilder {
        private Integer id;
        @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
        private Calendar invoiceDate;
        private Double totalPrice; 
      private Seller seller;
        
        public SellerInvoiceDTOBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public SellerInvoiceDTOBuilder invoiceDate(Calendar invoiceDate){
            this.invoiceDate = invoiceDate;
            return this;
        }
        
        public SellerInvoiceDTOBuilder totalPrice(Double totalPrice){
            this.totalPrice = totalPrice;
            return this;
        }
         
      public SellerInvoiceDTOBuilder seller(Seller seller){
            this.seller = seller;
            return this;
        }
         
        public SellerInvoiceDTO build(){
            return new SellerInvoiceDTO(this);
        }  
    }     
}
