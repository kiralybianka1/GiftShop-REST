package hu.giftshop.controller;

import hu.giftshop.dto.OrderDTO;
import hu.giftshop.dto.OrderInvoiceDTO;
import hu.giftshop.entity.OrderInvoice;
import hu.giftshop.repository.BaseRepository;
import hu.giftshop.repository.CustomerOrderRepository;
import hu.giftshop.repository.OrderInvoiceRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrderInvoiceController extends BaseController<OrderInvoice> {

    @EJB
    private OrderInvoiceRepository orderInvoiceRepository;
    
    @EJB 
    private CustomerOrderRepository customerOrderRepository; 

    @EJB
    private OrderProductController orderProductController;
    
    @EJB
    private CustomerOrderController orderController;
    
    public OrderInvoiceController(){
        super();
    }
    
    @Override
    protected BaseRepository<OrderInvoice> getRepository() {
         return orderInvoiceRepository;
    }
    
    public void create(OrderInvoice orderInvoice) {
        System.out.println(orderInvoice.getOrder().getOrderProductList());
        orderInvoiceRepository.save(orderInvoice);
    }
    
    public List<OrderInvoiceDTO> getOrderInvoices(){
        List<OrderInvoiceDTO> orderInvoices = new ArrayList<>();
        for (OrderInvoice orderInvoice : findAll()) {
                OrderDTO customerOrder = orderController.getOrdersById(orderInvoice.getOrder().getId());
                Calendar orderDate = customerOrder.getOrderDate();
                Calendar fulfillDate = customerOrder.getFulfillDate();
                customerOrder.setOrderDate(CustomerOrderController.hotfixCalendar(orderDate));
                customerOrder.setFulfillDate(CustomerOrderController.hotfixCalendar(fulfillDate));
                orderInvoices.add(new OrderInvoiceDTO.OrderInvoiceDTOBuilder()
                                              .id(orderInvoice.getId())
                                              .order(customerOrder)
                                              .build()
           );
           
        }
        return orderInvoices;
    }
    
    public OrderInvoiceDTO getOrderInvoiceById(int id){
        OrderInvoice orderInvoice = find(id);
        OrderDTO customerOrder = orderController.getOrdersById(orderInvoice.getOrder().getId());
        Calendar orderDate = customerOrder.getOrderDate();
        Calendar fulfillDate = customerOrder.getFulfillDate();
        customerOrder.setOrderDate(CustomerOrderController.hotfixCalendar(orderDate));
        customerOrder.setFulfillDate(CustomerOrderController.hotfixCalendar(fulfillDate));
        return new OrderInvoiceDTO.OrderInvoiceDTOBuilder()
                             .id(orderInvoice.getId())
                             .order(customerOrder)
                             .build();
    }
}
