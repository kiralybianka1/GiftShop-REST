package hu.giftshop.rest;

import hu.giftshop.entity.Address;
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

@Path("addresses")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_JSON})
public interface IAddressResource {
    
    @GET
    List<Address> getAddresses();
    
    @GET
    @Path("{id}")
    Address getAddress(@PathParam("id") int id);
    
    @POST
    Response createAddress(Address address);
    
    @PUT
    Response updateAddress(Address address);
    
    @DELETE
    @Path("{id}")
    Response deleteAddress(@PathParam("id") int id);
    
}
