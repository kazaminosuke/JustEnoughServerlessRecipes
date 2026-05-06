package com.draconicvelum.justenoughserverlessrecipes;

import com.draconicvelum.justenoughserverlessrecipes.config.JESRConfig;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.loading.FMLEnvironment;

@Mod("justenoughserverlessrecipes")
public class JustEnoughServerlessRecipesNeoForge {
    public JustEnoughServerlessRecipesNeoForge(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, JESRConfig.CLIENT_SPEC);
        if (FMLEnvironment.getDist() == Dist.CLIENT) {
            JustEnoughServerlessRecipesNeoForgeClient.init();
        }
    }
}
