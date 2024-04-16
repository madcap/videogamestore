package org.maats.videogamestore.domain.checkout;

import lombok.Data;

@Data
public class CheckoutResult {
    private String transactionId;
    private String guid;
    private String dueDateTime;
}
