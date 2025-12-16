package com.paymenttools.payout;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Collections;

import static org.mockito.Mockito.*;

@SpringBootTest
class PayoutServiceTest {

    @Mock TransactionRepository txRepo;
    @Mock BankClient bankClient;
    @InjectMocks PayoutService payoutService;

    @Test
    void testPayout() throws InterruptedException {
        // Setup
        Transaction tx = new Transaction();
        tx.setId("1");
        tx.setAmount(BigDecimal.TEN);
        when(txRepo.findAllByStatus("PENDING")).thenReturn(Collections.singletonList(tx));
        when(bankClient.transfer(any(), any())).thenReturn(true);

        new Thread(() -> payoutService.processDailyPayouts()).start();
        new Thread(() -> payoutService.processDailyPayouts()).start();

        Thread.sleep(1000);
        verify(bankClient, atLeastOnce()).transfer(any(), any());
    }
}