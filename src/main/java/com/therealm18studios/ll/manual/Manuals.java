package com.therealm18studios.ll.manual;

import com.therealm18studios.ll.LL;
import li.cil.manual.api.ManualModel;
import li.cil.manual.api.Tab;
import li.cil.manual.api.prefab.Manual;
import li.cil.manual.api.prefab.tab.ItemStackTab;
import li.cil.manual.api.provider.DocumentProvider;
import li.cil.manual.api.provider.PathProvider;
import li.cil.manual.api.util.Constants;
import li.cil.oc2.common.item.Items;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@OnlyIn(Dist.CLIENT)
public final class Manuals {

    private static final DeferredRegister<ManualModel> MANUALS = DeferredRegister.create(Constants.MANUAL_REGISTRY, Constants.MOD_ID);
    private static final DeferredRegister<PathProvider> PATH_PROVIDERS = DeferredRegister.create(Constants.PATH_PROVIDER_REGISTRY, Constants.MOD_ID);
    private static final DeferredRegister<DocumentProvider> CONTENT_PROVIDERS = DeferredRegister.create(Constants.DOCUMENT_PROVIDER_REGISTRY, Constants.MOD_ID);
    private static final DeferredRegister<Tab> TABS = DeferredRegister.create(Constants.TAB_REGISTRY, Constants.MOD_ID);

    ///////////////////////////////////////////////////////////////////

    public static final RegistryObject<ManualModel> MANUAL = MANUALS.register("manual", Manual::new);

    ///////////////////////////////////////////////////////////////////

    public static void initialize() {
        MANUALS.register(FMLJavaModLoadingContext.get().getModEventBus());

        PATH_PROVIDERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTENT_PROVIDERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TABS.register(FMLJavaModLoadingContext.get().getModEventBus());

        TABS.register("ll", () -> new ItemStackTab(
            ManualModel.LANGUAGE_KEY + "/ll/index.md",
            Component.translatable("manual." + LL.MOD_ID + ".items"),
            new ItemStack(Items.MANUAL.get())));
    }
}
