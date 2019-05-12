package hu.giftshop.rest.impl;

import hu.giftshop.controller.CustomerOrderController;
import hu.giftshop.controller.OrderProductController;
import hu.giftshop.dto.OrderDTO;
import hu.giftshop.entity.CustomerOrder;
import hu.giftshop.rest.IOrderResource;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class OrderReourceImpl implements IOrderResource {
    
    @EJB
    private CustomerOrderController orderController;
    
    @EJB
    private OrderProductController orderProductController;

    @Override
    public List<OrderDTO> getOrders() {
        return orderController.getOrders();
    }
    
    @Override
    public OrderDTO getOrdersById(int id) {
        return orderController.getOrdersById(id);
    }
    
    @Override
    public Response createOrder(String order) {
        orderController.createCustomerOrder(order);
        return Response.ok().build();
    }

    @Override
    public Response updateOrder(CustomerOrder order) {
        orderController.update(order);
        CustomerOrder entity = orderController.find(order.getId());
        return Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }

    @Override
    public Response deleteOrder(int id) {
        orderController.delete(id);
        return Response.ok().build();
    }
}
