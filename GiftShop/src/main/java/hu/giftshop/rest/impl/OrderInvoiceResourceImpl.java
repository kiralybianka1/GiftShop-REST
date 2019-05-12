package hu.giftshop.rest.impl;

import hu.giftshop.controller.OrderInvoiceController;
import hu.giftshop.dto.OrderInvoiceDTO;
import hu.giftshop.entity.OrderInvoice;
import hu.giftshop.rest.IOrderInvoiceResource;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class OrderInvoiceResourceImpl implements IOrderInvoiceResource{

    @EJB
    private OrderInvoiceController orderInvoiceController;
    
    @Override
    public List<OrderInvoiceDTO> getOrderInvoices() {
        return orderInvoiceController.getOrderInvoices();
    }
    
    @Override
    public OrderInvoiceDTO getOrderInvoiceById(int id) {
        return orderInvoiceController.getOrderInvoiceById(id);    
    }

    @Override
    public Response createOrderInvoice(OrderInvoice orderInvoice) {
        orderInvoiceController.create(orderInvoice);
        OrderInvoice affectedOrderInvoice = orderInvoiceController.find(orderInvoice.getId());
        return Response.ok(affectedOrderInvoice, MediaType.APPLICATION_JSON).build();
    }
}
