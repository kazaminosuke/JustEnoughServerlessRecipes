package com.draconicvelum.justenoughserverlessrecipes.config;

import com.draconicvelum.justenoughserverlessrecipes.JustEnoughServerlessRecipesLog;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.file.FileNotFoundAction;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class JESRConfig {
    private static final String FILE_NAME = "justenoughserverlessrecipes-client.toml";
    private static final String KEY_COOLDOWN = "transfer.cooldownTicks";
    private static final int DEFAULT_COOLDOWN = 1;
    private static final int MIN_COOLDOWN = 0;
    private static final int MAX_COOLDOWN = 200;

    private static volatile int cooldownTicks = DEFAULT_COOLDOWN;

    public static void load() {
        Path configPath = FabricLoader.getInstance().getConfigDir().resolve(FILE_NAME);
        try (CommentedFileConfig config = CommentedFileConfig.builder(configPath)
                .onFileNotFound(FileNotFoundAction.CREATE_EMPTY)
                .build()) {
            config.load();

            int raw = config.getOrElse(KEY_COOLDOWN, DEFAULT_COOLDOWN);
            cooldownTicks = Math.max(MIN_COOLDOWN, Math.min(MAX_COOLDOWN, raw));

            config.setComment(KEY_COOLDOWN,
                    "Minimum ticks between serverless recipe transfers (0 = unlimited, default: 1)." +
                    " Increase if the server kicks you for sending too many packets." +
                    "\nRange: " + MIN_COOLDOWN + " ~ " + MAX_COOLDOWN);
            config.set(KEY_COOLDOWN, cooldownTicks);
            config.save();

            JustEnoughServerlessRecipesLog.LOGGER.info("Loaded JESR config: cooldownTicks={}", cooldownTicks);
        } catch (Exception e) {
            cooldownTicks = DEFAULT_COOLDOWN;
            JustEnoughServerlessRecipesLog.LOGGER.error("Failed to load JESR config, using default ({})", DEFAULT_COOLDOWN, e);
        }
    }

    public static int getCooldownTicks() {
        return cooldownTicks;
    }
}
