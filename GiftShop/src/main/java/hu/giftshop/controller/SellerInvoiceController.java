package hu.giftshop.controller;

import hu.giftshop.dto.SellerInvoiceDTO;
import hu.giftshop.entity.SellerInvoice;
import hu.giftshop.repository.BaseRepository;
import hu.giftshop.repository.SellerInvoiceRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SellerInvoiceController extends BaseController<SellerInvoice>{
    
    @EJB
    private SellerInvoiceRepository sellerInvoiceRepository;

    public SellerInvoiceController() {
        super();
    }
    
    @Override
    protected BaseRepository<SellerInvoice> getRepository() {
        return sellerInvoiceRepository;
    }

    public void create(SellerInvoice sellerInvoice) {
        sellerInvoiceRepository.save(sellerInvoice);
    }

    @Override
    public void update(SellerInvoice sellerInvoice) {
        sellerInvoiceRepository.update(sellerInvoice);
    }

    @Override
    public void delete(int id) {
        getRepository().delete(getRepository().find(id));
    }
    
    public List<SellerInvoiceDTO> getSellerInvoices() {
        List<SellerInvoiceDTO> productDTOList = new ArrayList<>();
        for (SellerInvoice invoice : findAll()) {
            Calendar invoiceDate = CustomerOrderController.hotfixCalendar(invoice.getInvoiceDate());
            
            productDTOList.add(
                    new SellerInvoiceDTO.SellerInvoiceDTOBuilder()
                            .id(invoice.getId())
                            .invoiceDate(invoiceDate)
                            .seller(invoice.getSeller())
                            .totalPrice(invoice.getTotalPrice())
                            .build()
            );
        }
        return productDTOList;
    }
    
    public SellerInvoiceDTO getSellerInvoice(int id){
        SellerInvoice invoice = find(id);
        return new SellerInvoiceDTO.SellerInvoiceDTOBuilder()
                            .id(invoice.getId())
                            .invoiceDate(invoice.getInvoiceDate())
                            .seller(invoice.getSeller())
                            .totalPrice(invoice.getTotalPrice())
                            .build();
    }
    
}
