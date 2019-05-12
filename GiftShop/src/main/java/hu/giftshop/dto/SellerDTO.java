package hu.giftshop.dto;

import hu.giftshop.entity.Address;

public class SellerDTO {
    
    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String accountNumber;
    private Address address;
    
   public SellerDTO(SellerDTOBuilder builder){
       this.id = builder.id;
       this.name = builder.name;
       this.phone = builder.phone;
       this.email = builder.email;
       this.accountNumber = builder.accountNumber;
       this.address = builder.address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
   public static class SellerDTOBuilder {
        private Integer id;
        private String name;
        private String phone;
        private String email;
        private String accountNumber;
        private Address address;
       
        public SellerDTOBuilder id(Integer id){
            this.id = id;
            return this;
        }
        
        public SellerDTOBuilder name(String name){
            this.name = name;
            return this;
        }
        
        public SellerDTOBuilder phone(String phone){
            this.phone = phone;
            return this;
        }
        
        public SellerDTOBuilder email(String email){
            this.email = email;
            return this;
        }
        
        public SellerDTOBuilder accountNumber(String accountNumber){
            this.accountNumber = accountNumber;
            return this;
        }
        
        public SellerDTOBuilder address(Address address){
            this.address = address;
            return this;
        }
       
        public SellerDTO build(){
            return new SellerDTO(this);
        }
   }
}
