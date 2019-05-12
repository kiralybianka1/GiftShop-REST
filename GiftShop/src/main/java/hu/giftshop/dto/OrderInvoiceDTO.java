package hu.giftshop.dto;

public class OrderInvoiceDTO {
    private Integer id;
    private OrderDTO order;

    public OrderInvoiceDTO(OrderInvoiceDTOBuilder builder) {
        this.id = builder.id;
        this.order = builder.order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public static class OrderInvoiceDTOBuilder {
        private Integer id;
        private OrderDTO order;
        
        public OrderInvoiceDTOBuilder id(Integer id){
            this.id = id;
            return this;
        }

        public OrderInvoiceDTOBuilder order(OrderDTO order){
            this.order = order;
            return this;
        }

        public OrderInvoiceDTO build(){
            return new OrderInvoiceDTO(this);
        }
    }
}
