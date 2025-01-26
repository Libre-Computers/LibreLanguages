package com.therealm18studios.ll;

import com.therealm18studios.ll.manual.Manuals;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod("ll")
public class LL {
    public static String MOD_ID = "ll";
    public LL() {
        EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> Manuals::initialize);
    }

}
