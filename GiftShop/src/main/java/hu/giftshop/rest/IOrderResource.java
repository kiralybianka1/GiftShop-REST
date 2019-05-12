package hu.giftshop.rest;

import hu.giftshop.dto.OrderDTO;
import hu.giftshop.entity.CustomerOrder;
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

@Path("orders")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_JSON})
public interface IOrderResource {
    
    @GET
    public List<OrderDTO> getOrders();

    @GET 
    @Path("{id}")
    OrderDTO getOrdersById(@PathParam("id") int id);

    @POST
    Response createOrder(String order);
    
    @PUT
    Response updateOrder(CustomerOrder order);
    
    @DELETE
    @Path("{id}")
    Response deleteOrder(@PathParam("id") int id);
    
}
