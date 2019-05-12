package hu.giftshop.rest;

import hu.giftshop.dto.OrderInvoiceDTO;
import hu.giftshop.entity.OrderInvoice;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("orderinvoices")
@Consumes({ MediaType.APPLICATION_JSON})
@Produces({ MediaType.APPLICATION_JSON})
public interface IOrderInvoiceResource {
    @GET
    List<OrderInvoiceDTO> getOrderInvoices();
    
    @GET
    @Path("{id}")
    OrderInvoiceDTO getOrderInvoiceById(@PathParam("id") int id);
    
    @POST
    Response createOrderInvoice(OrderInvoice orderInvoice);
}
