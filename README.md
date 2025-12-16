# Scenario

## Business Context
We aggregate **5 million daily transactions** and settle funds to **100,000 merchants**.
This service runs on Kubernetes (GCP).

## Key Requirements
1. **Schedule:** Runs daily at 02:00 AM UTC.
2. **Safety:** **EXACTLY-ONCE** payout. Double payments are a disaster.
3. **Constraints:** External Bank API is **slow (2s/req)** and **rate-limited (50 req/sec)**.

## Tasks
1. **Architecture Review:** Open [architecture diagram](./docs/architecture.puml). Identify the **3 critical flaws** that will cause failure in Production.
2. **Code Review:** Open [PayoutService](./src/main/java/com/paymenttools/payout/PayoutService.java). Identify why the code is not production-ready (Safety, Performance, Reliability).
3. **Implementation:** Build a thread-safe `IdempotencyService` to prevent double payments.