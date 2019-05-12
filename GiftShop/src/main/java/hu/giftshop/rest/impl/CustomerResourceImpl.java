package hu.giftshop.rest.impl;

import hu.giftshop.controller.AddressController;
import hu.giftshop.controller.CustomerController;
import hu.giftshop.dto.CustomerDTO;
import hu.giftshop.dto.OrderDTO;
import hu.giftshop.entity.Address;
import hu.giftshop.entity.Customer;
import hu.giftshop.rest.ICustomerResource;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class CustomerResourceImpl implements ICustomerResource {
    
    @EJB
    private CustomerController customerController;

    @EJB
    private AddressController addressController;
    
    @Override
    public List<CustomerDTO> getCustomers() {
        return customerController.getCustomers();
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerController.getCustomer(id);
    }

    @Override
    public Response createCustomer(Customer customer) {
        customerController.create(customer);
        Customer affectedEntity = customerController.find(customer.getId());
        return Response.ok(affectedEntity, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response updateCustomer(Customer customer) {
        customerController.update(customer);
        Customer affectedEntity = customerController.find(customer.getId());
        return Response.ok(affectedEntity, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteCustomer(int id) {
        Customer customer = customerController.find(id);
        Address address = addressController.find(customer.getAddress().getId());
        customerController.delete(id);
        return Response.ok().build();
    }    

    @Override
    public List<OrderDTO> getOrdersByCustomerId(int customerId) {
        return customerController.getOrdersByCustomerId(customerId);
    }
}
