package hu.giftshop.rest;

import hu.giftshop.dto.SellerInvoiceDTO;
import hu.giftshop.entity.SellerInvoice;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("sellerinvoices")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_JSON})
public interface ISellerInvoiceResource {
    
    @GET
    public List<SellerInvoiceDTO> getSellerInvoices();
    
    @GET
    @Path("{id}")
    public SellerInvoiceDTO getSellerInvoice(@PathParam("id") int id);
    
    @POST
    public Response createSellerInvoice(SellerInvoice sellerInvoice);

}
