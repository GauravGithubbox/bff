package ca.loblaw.bff.service.impl;

import ca.loblaw.bff.entity.Customer;
import ca.loblaw.bff.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * The type Customer service.
 */
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private RestTemplate restTemplate;
    /**
     * The Uri.
     */
    String uri="http://localhost:8080/";
    @Override
    public Customer searchCustomer(String emailId,String lobId) {
        return  restTemplate.getForObject(uri+emailId+"/"+lobId, Customer.class);
    }
}
