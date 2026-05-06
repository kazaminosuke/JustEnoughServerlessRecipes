package com.draconicvelum.justenoughserverlessrecipes.transfer;

import com.draconicvelum.justenoughserverlessrecipes.config.JESRConfig;

public final class TransferRateLimiter {
    private static final TransferRateLimiter INSTANCE = new TransferRateLimiter();
    private long lastTransferNanos = Long.MIN_VALUE / 2;

    private TransferRateLimiter() {}

    public static TransferRateLimiter getInstance() {
        return INSTANCE;
    }

    public boolean tryAcquire() {
        int cooldownTicks = JESRConfig.TRANSFER_COOLDOWN_TICKS.get();
        if (cooldownTicks <= 0) {
            return true;
        }
        long now = System.nanoTime();
        long cooldownNanos = (long) cooldownTicks * 50_000_000L;
        if (now - lastTransferNanos >= cooldownNanos) {
            lastTransferNanos = now;
            return true;
        }
        return false;
    }
}
