package com.paymenttools.payout;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PayoutService {

    private final TransactionRepository txRepo;
    private final BankClient bankClient;

    public void processDailyPayouts() {
        System.out.println("Starting daily payout process...");
        List<Transaction> transactions = txRepo.findAllByStatus("PENDING");
        for (Transaction tx : transactions) {
            try {
                boolean success = bankClient.transfer(tx.getMerchantId(), tx.getAmount());

                if (success) {
                    tx.setStatus("PAID");
                    txRepo.save(tx);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}