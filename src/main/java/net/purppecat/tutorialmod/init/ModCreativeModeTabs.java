package net.purppecat.tutorialmod.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.purppecat.tutorialmod.TutorialMod;
import net.purppecat.tutorialmod.init.ModItems;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> PURP_ITEMS_TAB = CREATIVE_MODE_TAB.register("purp_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MAGICSTICK.get())
                    ).title(Component.translatable("creativetab.tutorialmod.purp_items"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        output.accept(ModItems.MAGICSTICK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}