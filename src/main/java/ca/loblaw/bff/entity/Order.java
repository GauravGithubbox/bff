package ca.loblaw.bff.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * The type Order.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderID;
    private String customerID;
    private Product[] cart;
    private String deliveryMode;
    private Delivery delivery;
    private String orderStatus;
    private String customerName;
    private String customerEmail;
    private String currency;
    private String voucher;
    private Date orderDate;
    private Double orderPrice;
    private Double finalOrderPrice;

    /**
     * Apply voucher boolean.
     *
     * @param voucher the voucher
     * @return the boolean
     */
    public boolean applyVoucher(String voucher) {
        this.applyVoucher(voucher);
        // Code to apply the voutcher
        this.setFinalOrderPrice(this.getOrderPrice());
        return true;
    }


}
