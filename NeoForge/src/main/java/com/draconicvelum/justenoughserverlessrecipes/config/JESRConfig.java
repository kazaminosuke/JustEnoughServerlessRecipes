package com.draconicvelum.justenoughserverlessrecipes.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public class JESRConfig {
    public static final ModConfigSpec CLIENT_SPEC;
    public static final ModConfigSpec.IntValue TRANSFER_COOLDOWN_TICKS;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.push("transfer");
        TRANSFER_COOLDOWN_TICKS = builder
                .comment("Minimum ticks between serverless recipe transfers (0 = unlimited, default: 1). Increase if the server kicks you for sending too many packets.")
                .defineInRange("cooldownTicks", 1, 0, 200);
        builder.pop();
        CLIENT_SPEC = builder.build();
    }
}
