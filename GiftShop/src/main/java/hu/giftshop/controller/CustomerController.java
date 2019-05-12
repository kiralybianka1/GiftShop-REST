package hu.giftshop.controller;

import hu.giftshop.dto.CustomerDTO;
import hu.giftshop.dto.OrderDTO;
import hu.giftshop.entity.Address;
import hu.giftshop.entity.Customer;
import hu.giftshop.entity.CustomerOrder;
import hu.giftshop.repository.BaseRepository;
import hu.giftshop.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CustomerController extends BaseController<Customer> {

    @EJB
    private CustomerRepository customerRepository;
    
    @EJB
    private CustomerOrderController customerOrderController;
    
    @EJB
    private ProductController productController;
    
    @EJB
    private AddressController addressController;
    
    public CustomerController(){
        super();
    }
    
    @Override
    protected BaseRepository<Customer> getRepository() {
        return customerRepository;
    }

    public List<CustomerDTO> getCustomers(){
        List<CustomerDTO> customers = new ArrayList<>();
        for(Customer customer : findAll()){
            customers.add(new CustomerDTO.CustomerDTOBuilder()
                                         .id(customer.getId())
                                         .firstName(customer.getFirstName())
                                         .lastName(customer.getLastName())
                                         .phone(customer.getPhone())
                                         .email(customer.getEmail())
                                         .customerType(customer.getCustomerType())
                                         .address(customer.getAddress())
                                         .accountNumber(customer.getAccountNumber())
                                         .build()
            );
        }
        return customers;
    }
    
    public CustomerDTO getCustomerDto(int id){
        Customer customer = find(id);
        return new CustomerDTO.CustomerDTOBuilder()
                              .id(customer.getId())
                              .firstName(customer.getFirstName())
                              .lastName(customer.getLastName())
                              .phone(customer.getPhone())
                              .email(customer.getEmail())
                              .customerType(customer.getCustomerType())
                              .address(customer.getAddress())
                              .accountNumber(customer.getAccountNumber())
                              .build();
    }
    
     public Customer getCustomer(int id) {
         return customerRepository.find(id);
    }

    public void create(Customer customer){
        Address customersAddress = customer.getAddress();
        Address address = addressController.getAddressByAllDetails(customersAddress);
        if(address == null){
            addressController.create(customersAddress);
        } else {
            customer.setAddress(address);
        }
        customerRepository.save(customer);
    }
    
    @Override
    public void update(Customer customer){
        addressController.update(customer.getAddress());
        customerRepository.update(customer);
    }
    
    @Override
    public void delete(int id){
        Customer customer = getRepository().find(id);
        Address address = addressController.find(customer.getAddress().getId());
        getRepository().delete(customer);
    }
    
    public List<OrderDTO> getOrdersByCustomerId(int id){
        List<OrderDTO> customersOrders = new ArrayList<>();
        for (CustomerOrder order : customerOrderController.findAll()) {
            if(order.getCustomer().getId().equals(id)){
                customersOrders.add(new OrderDTO.OrderDTOBuilder()
                            .id(order.getId())
                            .orderDate(CustomerOrderController.hotfixCalendar(order.getOrderDate()))
                            .fulfillDate(CustomerOrderController.hotfixCalendar(order.getFulfillDate()))
                            .customer(order.getCustomer())
                            .orderProductList(order.getOrderProductList())
                            .build()
                );
            }
        }
        return customersOrders;
    }

}
