package hu.giftshop.dto;

import hu.giftshop.entity.Address;

public class CustomerDTO {
 
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String customerType;
    private Address address;
    private String accountNumber;
    
    public CustomerDTO(CustomerDTOBuilder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phone = builder.phone;
        this.email = builder.email;
        this.customerType = builder.customerType;
        this.address = builder.address;
        this.accountNumber = builder.accountNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public static class CustomerDTOBuilder {
        private Integer id;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private String customerType;
        private Address address;
        private String accountNumber;
        
        public CustomerDTOBuilder id(Integer id){
            this.id = id;
            return this;
        }
               
        public CustomerDTOBuilder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        
        public CustomerDTOBuilder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        
        public CustomerDTOBuilder phone(String phone){
            this.phone = phone;
            return this;
        }
        
        public CustomerDTOBuilder email(String email){
            this.email = email;
            return this;
        }
        
        public CustomerDTOBuilder customerType(String customerType){
            this.customerType = customerType;
            return this;
        }
        
        public CustomerDTOBuilder address(Address address){
            this.address = address;
            return this;
        }
        
        public CustomerDTOBuilder accountNumber(String accountNumber){
            this.accountNumber = accountNumber;
            return this;
        }   
        
        public CustomerDTO build(){
            return new CustomerDTO(this);
        }
        
    }
    
}
