package hu.giftshop.rest.impl;

import hu.giftshop.controller.OrderProductController;
import hu.giftshop.dto.OrderProductDTO;
import hu.giftshop.rest.IOrderProductResource;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;

@RequestScoped
public class OrderProductResourceImpl implements IOrderProductResource{
    
    @EJB
    private OrderProductController orderProductController;

    @Override
    public List<OrderProductDTO> getOrderProducts() {
        return orderProductController.getOrderProducts();
    }

}
