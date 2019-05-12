package hu.giftshop.rest;

import hu.giftshop.dto.CustomerDTO;
import hu.giftshop.dto.OrderDTO;
import hu.giftshop.entity.Customer;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("customers")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_JSON})
public interface ICustomerResource {
    
    @GET
    List<CustomerDTO> getCustomers();
    
    @GET
    @Path("{id}")
    Customer getCustomerById(@PathParam("id") int id);
    
    @POST
    Response createCustomer(Customer customer);
    
    @PUT
    Response updateCustomer(Customer customer);
    
    @DELETE
    @Path("{id}")
    Response deleteCustomer(@PathParam("id") int id);
    
    @GET
    @Path("{id}/orders")
    List<OrderDTO> getOrdersByCustomerId(@PathParam("id") int id);  
    
}
