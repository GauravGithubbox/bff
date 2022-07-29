package ca.loblaw.bff.service;


import ca.loblaw.bff.entity.Order;

/**
 * The interface Order search.
 */
public interface OrderSearch {

    /**
     * Gets order detailsby id.
     *
     * @param orderId the order id
     * @return the order detailsby id
     */
    public Order getOrderDetailsbyID(String orderId);

    /**
     * Get order detailsby customer id order [ ].
     *
     * @return the order [ ]
     */
    public Order[] getOrderDetailsbyCustomerID();

    /**
     * Gets order statusby id.
     *
     * @return the order statusby id
     */
    public String getOrderStatusbyID();

    /**
     * Search order by date order [ ].
     *
     * @param orderDate the order date
     * @return the order [ ]
     */
    public Order[] searchOrderByDate(String orderDate);

    /**
     * Search order by order no order [ ].
     *
     * @param orderNumber the order number
     * @return the order [ ]
     */
    public Order[] searchOrderByOrderNo(String orderNumber);

    /**
     * Search order by customer name order [ ].
     *
     * @param customerName the customer name
     * @return the order [ ]
     */
    public Order[] searchOrderByCustomerName(String customerName);

    /**
     * Search order by delivery mode order [ ].
     *
     * @param deliveryMode the delivery mode
     * @return the order [ ]
     */
    public Order[] searchOrderByDeliveryMode(String deliveryMode);

    /**
     * Search order by order status order [ ].
     *
     * @param orderStatus the order status
     * @return the order [ ]
     */
    public Order[] searchOrderByOrderStatus(String orderStatus);

    /**
     * Apply voucher string.
     *
     * @param voucher the voucher
     * @param orderId the order id
     * @return the string
     */
    public String applyVoucher(String voucher,String orderId);

    /**
     * Cancel order by id string.
     *
     * @param orderId the order id
     * @return the string
     */
    public String cancelOrderById(String orderId);

}
