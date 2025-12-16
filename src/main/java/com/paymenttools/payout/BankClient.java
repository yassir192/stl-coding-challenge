package com.paymenttools.payout;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class BankClient {
    public boolean transfer(String merchantId, BigDecimal amount) {
        // Simulates external call
        return true;
    }
}