package ca.loblaw.bff.service;
import ca.loblaw.bff.entity.Customer;

/**
 * The interface Customer service.
 */
public interface ICustomerService {

    /**
     * Search customer customer.
     *
     * @param id    the id
     * @param lobId the lob id
     * @return the customer
     */
     Customer searchCustomer(String  id,String lobId);
    }


