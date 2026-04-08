package com.draconicvelum.justenoughserverlessrecipes;

import com.draconicvelum.justenoughserverlessrecipes.recipes.DatapackRecipeMapBuilder;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import net.minecraft.resources.Identifier;

@JeiPlugin
public class JustEnoughServerlessRecipesPlugin implements IModPlugin {
    public static IJeiRuntime runtime;

    @Override
    public Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath("justenoughserverlessrecipes", "plugin");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        tryInjectDatapackRecipes("registerRecipes()");
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        runtime = jeiRuntime;
        tryInjectDatapackRecipes("onRuntimeAvailable()");
    }

    @Override
    public void onRuntimeUnavailable() {
        runtime = null;
    }

    public static boolean tryInjectDatapackRecipes(String source) {
        var currentMap = mezz.jei.common.Internal.getClientSyncedRecipes();
        if (!currentMap.values().isEmpty()) {
            return false;
        }

        var datapackMap = DatapackRecipeMapBuilder.build();
        if (datapackMap.values().isEmpty()) {
            JustEnoughServerlessRecipesLog.LOGGER.warn("Datapack recipe map is empty from {}", source);
            return false;
        }

        mezz.jei.common.Internal.setClientSyncedRecipes(datapackMap);
        JustEnoughServerlessRecipesLog.LOGGER.info("Injected datapack recipe map from {}", source);
        return true;
    }
}
