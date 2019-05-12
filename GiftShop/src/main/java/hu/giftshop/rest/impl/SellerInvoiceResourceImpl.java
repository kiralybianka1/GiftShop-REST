package hu.giftshop.rest.impl;

import hu.giftshop.controller.SellerInvoiceController;
import hu.giftshop.dto.SellerInvoiceDTO;
import hu.giftshop.entity.SellerInvoice;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import hu.giftshop.rest.ISellerInvoiceResource;

@RequestScoped
public class SellerInvoiceResourceImpl implements ISellerInvoiceResource{
    @EJB
    private SellerInvoiceController sellerInvoiceController;

    @Override
    public List<SellerInvoiceDTO> getSellerInvoices() {
        return sellerInvoiceController.getSellerInvoices();
    }

    @Override
    public SellerInvoiceDTO getSellerInvoice(int id) {
        return sellerInvoiceController.getSellerInvoice(id);
    }

    @Override
    public Response createSellerInvoice(SellerInvoice sellerInvoice) {
        sellerInvoiceController.create(sellerInvoice);
        SellerInvoice affectedSellerInvoice = sellerInvoiceController.find(sellerInvoice.getId());
        return Response.ok(affectedSellerInvoice, MediaType.APPLICATION_JSON).build();
    }
}
