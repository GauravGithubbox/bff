package ca.loblaw.bff.controller;


import ca.loblaw.bff.entity.Order;
import ca.loblaw.bff.service.impl.OrderSearchimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Order details controller.
 */
@ComponentScan
@RestController
public class OrderDetailsController {

    /**
     * The Order searchimpl.
     */
    @Autowired
    OrderSearchimpl orderSearchimpl;

    /**
     * Search order details by id response entity.
     *
     * @param orderId the order id
     * @return the response entity
     */
    @GetMapping("/order-details/{orderId}")
//    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Order> searchOrderDetailsById(@PathVariable String orderId)
    {
        Order currentorder = orderSearchimpl.getOrderDetailsbyID(orderId);
        if(currentorder != null)
        {
            return ResponseEntity.ok(currentorder);
        }
        else return ResponseEntity.notFound().build();
    }

    /**
     * Search order all response entity.
     *
     * @param orderDate    the order date
     * @param orderNumber  the order number
     * @param customerName the customer name
     * @param deliveryMode the delivery mode
     * @param orderStatus  the order status
     * @return the response entity
     */
    @GetMapping("/allOrders")
    //  @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<List<Order>> searchOrderAll(@RequestParam(value = "orderDate" ,required = false)String orderDate,
                                                      @RequestParam(value = "orderNumber",required = false)String orderNumber,
                                                      @RequestParam(value = "customerName",required = false)String customerName,
                                                      @RequestParam(value = "deliveryMode",required = false)String deliveryMode,
                                                      @RequestParam(value = "orderStatus",required = false)String orderStatus
    )
    {
        List<Order> orderList=new ArrayList<>();
        orderList.addAll(List.of(orderSearchimpl.searchOrderByDate(orderDate)));
        orderList.addAll(List.of(orderSearchimpl.searchOrderByOrderNo(orderNumber)));
        orderList.addAll(List.of(orderSearchimpl.searchOrderByCustomerName(customerName)));
        orderList.addAll(List.of(orderSearchimpl.searchOrderByDeliveryMode(deliveryMode)));
        orderList.addAll(List.of(orderSearchimpl.searchOrderByOrderStatus(deliveryMode)));
        if(!orderList.isEmpty())
        {
            return ResponseEntity.ok(orderList);
        }
        else return ResponseEntity.notFound().build();
    }

    /**
     * Cancel order by id response entity.
     *
     * @param orderId the order id
     * @return the response entity
     */
    @GetMapping("/order/cancel/{orderId}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> cancelOrderById(@PathVariable String orderId)
    {
        String status= orderSearchimpl.cancelOrderById(orderId);
        if(!status.isEmpty())
        {
            return ResponseEntity.ok(status);
        }
        else return ResponseEntity.notFound().build();
    }

    /**
     * Search order all response entity.
     *
     * @param voucher the voucher
     * @param orderID the order id
     * @return the response entity
     */
    @GetMapping("order/applyVoucher")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> searchOrderAll(@RequestParam(value = "voucher" ,required = true)String voucher,
                                                 @RequestParam(value = "orderID",required = true)String orderID
    )
    {
        String status= orderSearchimpl.applyVoucher(voucher,orderID);
        if(!status.isEmpty())
        {
            return ResponseEntity.ok(status);
        }
        else return ResponseEntity.notFound().build();
    }


}
