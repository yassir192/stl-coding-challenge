package com.paymenttools.payout;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
public class Transaction {
    @Id
    private String id;
    private String merchantId;
    private BigDecimal amount;
    private String status;
}