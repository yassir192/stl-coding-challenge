package com.paymenttools.payout;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payouts")
@RequiredArgsConstructor
public class PayoutController {

    private final PayoutService payoutService;

    /**
     * Triggered by Kubernetes CronJob via HTTP POST
     */
    @PostMapping("/trigger")
    public ResponseEntity<String> triggerPayouts() {
        payoutService.processDailyPayouts();
        return ResponseEntity.ok("Payout process started");
    }
}