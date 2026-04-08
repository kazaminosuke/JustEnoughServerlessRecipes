package com.draconicvelum.justenoughserverlessrecipes;

import mezz.jei.fabric.events.JeiLifecycleEvents;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public class JustEnoughServerlessRecipesMod implements ClientModInitializer {

    public static boolean isSingleplayer = false;

    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> {
            isSingleplayer = client.isSingleplayer();

            JustEnoughServerlessRecipesLog.LOGGER.info("Mode: {}", isSingleplayer ? "Singleplayer" : "Multiplayer");

            client.execute(() -> {
                boolean injected = JustEnoughServerlessRecipesPlugin.tryInjectDatapackRecipes("ClientPlayConnectionEvents.JOIN");
                if (injected) {
                    JeiLifecycleEvents.AFTER_RECIPE_SYNC.invoker().run();
                }
            });
        });
    }
}
