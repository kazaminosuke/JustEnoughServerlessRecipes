package com.draconicvelum.justenoughserverlessrecipes.transfer;

public final class TransferRateLimiter {
    private static final TransferRateLimiter INSTANCE = new TransferRateLimiter();
    // Default: 1 tick (50 ms). No config API on Fabric; adjust at compile time if needed.
    private static final int DEFAULT_COOLDOWN_TICKS = 1;
    private volatile long lastTransferNanos = Long.MIN_VALUE / 2;

    private TransferRateLimiter() {}

    public static TransferRateLimiter getInstance() {
        return INSTANCE;
    }

    public void reset() {
        lastTransferNanos = Long.MIN_VALUE / 2;
    }

    public boolean tryAcquire() {
        if (DEFAULT_COOLDOWN_TICKS <= 0) {
            return true;
        }
        long now = System.nanoTime();
        long cooldownNanos = (long) DEFAULT_COOLDOWN_TICKS * 50_000_000L;
        if (now - lastTransferNanos >= cooldownNanos) {
            lastTransferNanos = now;
            return true;
        }
        return false;
    }
}
