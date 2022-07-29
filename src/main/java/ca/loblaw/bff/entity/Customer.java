package ca.loblaw.bff.entity;

import lombok.*;

/**
 * The type Customer.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    /**
     * The Id.
     */
    String id;
    /**
     * The Name.
     */
    String name;
    /**
     * The Email.
     */
    String email;
}

