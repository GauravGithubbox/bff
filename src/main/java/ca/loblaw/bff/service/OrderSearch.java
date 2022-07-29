package ca.loblaw.bff.service;


import ca.loblaw.bff.entity.Order;

public interface OrderSearch {

    public Order getOrderDetailsbyID(String orderId);
    public Order[] getOrderDetailsbyCustomerID();
    public String getOrderStatusbyID();

    public Order[] searchOrderByDate(String orderDate);
    public Order[] searchOrderByOrderNo(String orderNumber);
    public Order[] searchOrderByCustomerName(String customerName);
    public Order[] searchOrderByDeliveryMode(String deliveryMode);
    public Order[] searchOrderByOrderStatus(String orderStatus);
    public String applyVoucher(String voucher,String orderId);
    public String cancelOrderById(String orderId);

}
