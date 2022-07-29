package ca.loblaw.bff.service.impl;

import ca.loblaw.bff.entity.Order;
import ca.loblaw.bff.service.OrderSearch;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class OrderSearchimpl implements OrderSearch {

    RestTemplate restTemplateForOrder=new RestTemplate();

    @Override
    public Order getOrderDetailsbyID(String orderId) {
                return new Order();
    }

    @Override
    public Order[] getOrderDetailsbyCustomerID()
    {
        return new Order[0];
    }

    @Override
    public String getOrderStatusbyID() {
        return null;
    }

    @Override
    public Order[] searchOrderByDate(String orderDate) {
        return new Order[0];
    }

    @Override
    public Order[] searchOrderByOrderNo(String orderNumber) {
        return new Order[0];
    }

    @Override
    public Order[] searchOrderByCustomerName(String customerName) {
        return new Order[0];
    }

    @Override
    public Order[] searchOrderByDeliveryMode(String deliveryMode) {
        return new Order[0];
    }

    @Override
    public Order[] searchOrderByOrderStatus(String orderStatus) {
        return new Order[0];
    }

    @Override
    public String applyVoucher(String voucher,String orderId) {
     /*     Order o=this.getOrderDetailsbyID(orderId);
            o.applyVoucher(voucher);
            return "Success";
     */

        String url = "http://localhost:8080/applyvoucher/{urlParameter}?queryParameter= {queryParameter}";
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity requestEntity = new HttpEntity<>(headers);
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("voucher",voucher);
        uriVariables.put("orderId", orderId);
        ResponseEntity<Map> response = template.exchange(url, HttpMethod.GET, requestEntity, Map.class, uriVariables);
        return response.getBody().toString();

    }
    @Override
    public String cancelOrderById(String orderId) {
String confirmation= restTemplateForOrder.getForObject("http://localhost:8080/CancleOrder"+orderId, String.class);
            return confirmation;
    }

}
