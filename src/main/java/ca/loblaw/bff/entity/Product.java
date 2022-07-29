package ca.loblaw.bff.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The type Product.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productID;
    private String productName;
    private Double productPrice;
    private String productLink;
    private String productCode;

}
