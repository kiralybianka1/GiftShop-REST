package hu.giftshop.rest;

import hu.giftshop.dto.ProductDTO;
import hu.giftshop.entity.Product;
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

@Path("products")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public interface IProductResource {
    
    @GET
    List<ProductDTO> getProducts();

    @GET
    @Path("{id}")
    Product getProduct(@PathParam("id") int id);
    
    @POST
    Response createProduct(Product product);
    
    @PUT
    Response updateProduct(Product product);
    
    @DELETE
    @Path("{id}")
    Response deleteProduct(@PathParam("id") int id);
    
}
