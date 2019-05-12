package hu.giftshop.controller;

import hu.giftshop.dto.OrderProductDTO;
import hu.giftshop.entity.OrderProduct;
import hu.giftshop.repository.BaseRepository;
import hu.giftshop.repository.OrderProductRepository;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrderProductController extends BaseController<OrderProduct>{
    
    @EJB
    private OrderProductRepository orderProductRepository;

    public OrderProductController(){
        super();
    }
    
    @Override
    protected BaseRepository<OrderProduct> getRepository() {
        return orderProductRepository;
    }
    
    public List<OrderProductDTO> getOrderProducts(){
        List<OrderProductDTO> orderProducts = new ArrayList<>();
        for (OrderProduct orderProduct : findAll()) {
            orderProducts.add(new OrderProductDTO.OrderProductDTOBuilder()
                                                 .product(orderProduct.getProduct())
                                                 .quantity(orderProduct.getQuantity())
                                                 .build()
            );
        }
        return orderProducts;
    }
    
    public void create(OrderProduct orderProduct){
        orderProductRepository.save(orderProduct);
    }
    
    public Integer createOrderProduct(OrderProduct orderProduct){
        return orderProductRepository.create(orderProduct);
    }
}
