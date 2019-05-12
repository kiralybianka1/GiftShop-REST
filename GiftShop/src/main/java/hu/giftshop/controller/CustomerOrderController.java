package hu.giftshop.controller;

import hu.giftshop.dto.OrderDTO;
import hu.giftshop.entity.Customer;
import hu.giftshop.entity.CustomerOrder;
import hu.giftshop.entity.OrderInvoice;
import hu.giftshop.entity.OrderProduct;
import hu.giftshop.entity.Product;
import hu.giftshop.repository.BaseRepository;
import hu.giftshop.repository.CustomerOrderRepository;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

@Stateless
public class CustomerOrderController extends BaseController<CustomerOrder> {

    @EJB
    private CustomerOrderRepository orderRepository;
    
    @Inject
    private Logger logger;
    
    @EJB
    private OrderInvoiceController orderInvoiceController;
    
    @EJB
    private ProductController productController;

    @EJB
    private OrderProductController orderProductController;
    
    @EJB
    private CustomerController customerController;
    
    public CustomerOrderController() {
        super();
    }
    
    @Override
    protected BaseRepository<CustomerOrder> getRepository() {
        return orderRepository;
    }
    
    public static Calendar hotfixCalendar(Calendar calendar){     
        if(calendar != null){
            Calendar newCalendar = Calendar.getInstance();
            newCalendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR));
            newCalendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
            newCalendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH));
            return newCalendar;
        }
        return null;
    }
    
    private Calendar stringToCalendar(String date){
        System.out.println("date:" + date);
        Calendar calendar = Calendar.getInstance();
        Integer year = Integer.parseInt(date.split("-")[0]);
        Integer month = Integer.parseInt(date.split("-")[1]);

        Integer day = Integer.parseInt(date.split("-")[2]);
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        System.out.println(calendar.toString());
        return calendar;
    }
    
    public void createCustomerOrder(String customerOrder){
        JsonReader reader = Json.createReader(new StringReader(customerOrder));
        JsonObject jsonObject = reader.readObject();
         
        CustomerOrder order = new CustomerOrder();
        order.setOrderDate(stringToCalendar(jsonObject.getString("orderDate")));
        if(jsonObject.isNull("fulfillDate")){
            order.setFulfillDate(null);
        } else {
            order.setFulfillDate(stringToCalendar(jsonObject.getString("fulfillDate")));
        } 
        
        int customerId = jsonObject.getJsonObject("customer").getInt("id");
        Customer customer = customerController.getCustomer(customerId);
        order.setCustomer(customer);

        List<OrderProduct> orderProductList= new ArrayList<>();
        order.setOrderProductList(orderProductList);
        Integer insertedId = orderRepository.createCustomerOrder(order);      
        
        JsonArray list = jsonObject.getJsonArray("orderProductList");
        for(int i = 0; i< list.size(); i++){
                OrderProduct orderProduct= new OrderProduct();
                Product product = productController.getProduct(list.getJsonObject(i).getJsonObject("product").getInt("id"));
                
                Integer newProductQuantity = product.getQuantity() - list.getJsonObject(i).getInt("quantity");
                product.setQuantity(newProductQuantity);
                productController.update(product);
                
                orderProduct.setProduct(product);
                orderProduct.setQuantity(list.getJsonObject(i).getInt("quantity"));
                orderProduct.setOrder(orderRepository.find(insertedId));
                
                orderProductController.create(orderProduct);
           }
        
        OrderInvoice orderInvoice = new OrderInvoice();
        orderInvoice.setOrder(orderRepository.find(insertedId));
        orderInvoiceController.create(orderInvoice);

    }
    
    
    
    @Override
    public void update(CustomerOrder order){
        orderRepository.update(order);
    }

    @Override
    public void delete(int id) {
        CustomerOrder order = find(id);
        for (OrderProduct item : order.getOrderProductList()) {
            Product product = item.getProduct();
            product.setQuantity(item.getProduct().getQuantity() + item.getQuantity());
            productController.update(product);  
        }
        orderRepository.delete(order);
    }
    
    public List<OrderDTO> getOrders(){
        List<OrderDTO> orders = new ArrayList<>();
        for (CustomerOrder order : findAll()) {
            OrderDTO dto = new OrderDTO.OrderDTOBuilder()
                                   .id(order.getId())
                                   .orderDate(hotfixCalendar(order.getOrderDate()))
                                   .fulfillDate(hotfixCalendar(order.getFulfillDate()))
                                   .customer(order.getCustomer())
                                   .orderProductList(order.getOrderProductList())
                                   .build();
            orders.add(dto);
            
        }
        return orders;
    }
    
    public OrderDTO getOrdersById(int id){
        CustomerOrder order = find(id);
        return new OrderDTO.OrderDTOBuilder()
                .id(order.getId())
                .orderDate(order.getOrderDate())
                .fulfillDate(order.getFulfillDate())
                .customer(order.getCustomer())
                .orderProductList(order.getOrderProductList())
                .build();
    }
    
    public List<OrderDTO> getOrdersByCustomerId(int customerId){
        List<OrderDTO> orders = new ArrayList<>();
       for (CustomerOrder order : findAll()) {
            if(order.getCustomer().getId().equals(customerId)){
                orders.add(new OrderDTO.OrderDTOBuilder()
                                       .id(order.getId())
                                       .orderDate(order.getOrderDate())
                                       .fulfillDate(order.getFulfillDate())
                                       .customer(order.getCustomer())
                                       .orderProductList(order.getOrderProductList())
                                       .build()
                );
            }
        }
        return orders;
    }  
}
