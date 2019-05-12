package hu.giftshop.rest;

import hu.giftshop.dto.SellerDTO;
import hu.giftshop.dto.SellerProductDTO;
import hu.giftshop.entity.Seller;
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

@Path("sellers")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface ISellerResource {
    
    @GET
    public List<SellerDTO> getSellers();
    
    @GET
    @Path("{id}")
    public SellerDTO getSellerById(@PathParam("id") int id);  
    
    @POST
    public Response createSeller(Seller seller);
    
    @PUT
    public Response updateSeller(Seller seller);
    
    @DELETE
    @Path("{id}")
    public Response deleteSeller(@PathParam("id") int id);
    
    @GET
    @Path("{id}/products")
    public List<SellerProductDTO>getSellersProducts(@PathParam("id") int id);
}
