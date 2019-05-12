package hu.giftshop.rest;

import hu.giftshop.entity.Category;
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

@Path("categories")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_JSON})
public interface ICategoryResource {
    
    @GET
    List<Category> getCategories();    
    
    @GET
    @Path("{id}")
    Category getCategory(@PathParam("id") int id);
    
    @POST
    Response createCategory(Category category);
    
    @PUT
    Response updateCategory(Category category);
    
    @DELETE
    @Path("{id}")
    Response deleteCategory(@PathParam("id") int id);
    
}
