package com.paymenttools.payout;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Service to manage concurrency locks.
 * This implementation uses an in-memory map for the sake of a coding exercise.
 * In a real Distributed System (Multi-Pod), this MUST be replaced with:
 * 1. Redis (SETNX command)
 * 2. Database Unique Constraint
 * 3. Zookeeper / Etcd
 */
@Service
public class IdempotencyKeyService {

    /**
     * Simulating a Distributed Lock Store (e.g., Redis or Database Table)
     */
    private final ConcurrentHashMap<String, Long> lockStore = new ConcurrentHashMap<>();

    /**
     * Tries to acquire a lock for a specific key.
     * This operation is ATOMIC.
     */
    public boolean acquireLock() {
        // TODO
        return false;
    }

    /**
     * Releases a lock explicitly.
     */
    public void releaseLock(String key) {
        // TODO

    }
}