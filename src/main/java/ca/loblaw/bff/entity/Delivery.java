package ca.loblaw.bff.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    private String deliveryID;
    private String deliveryType;
    private String deliveryAddress;
    private String deliveryMode;
    private String trackingNumber;
    private String courierType;

}
