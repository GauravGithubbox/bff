package ca.loblaw.bff.controller;

import ca.loblaw.bff.entity.Customer;
import ca.loblaw.bff.service.ICustomerService;
import ca.loblaw.bff.service.impl.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Customer search controller.
 */
@RestController
@RequestMapping("/customer")
public class CustomerSearchController {
    @Autowired
    private CustomerService customerService;

    /**
     * Search customer.
     *
     * @param emailId the email id
     * @param lobId   the lob id
     * @return the customer
     */
    @GetMapping("/{emailId}/{lobId}")
    public Customer search(@PathVariable String emailId,String lobId) {
        return customerService.searchCustomer(emailId,lobId);
    }
}
