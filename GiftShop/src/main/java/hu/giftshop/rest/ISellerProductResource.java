package hu.giftshop.rest;

import hu.giftshop.dto.SellerProductDTO;
import hu.giftshop.entity.SellerProduct;
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

@Path("sellerproducts")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface ISellerProductResource {
    
    @GET
    public List<SellerProductDTO> getSellerProducts();

    @GET
    @Path("{id}")
    public SellerProductDTO getSellerProduct(@PathParam("id") int id);
    
    @POST
    public Response createSellerProduct(SellerProduct product);
    
    @PUT
    public Response updateSellerProduct(SellerProduct product);
    
    @DELETE
    @Path("{id}")
    public Response deleteSellerProduct(@PathParam("id") int id);
    
}
