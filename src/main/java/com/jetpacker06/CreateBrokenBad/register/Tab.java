package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class Tab {
    public static final ResourceKey<CreativeModeTab> CREATIVE_TAB =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CreateBrokenBad.MOD_ID, "group"));

    public static void register(Registrate REGISTRATE) {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CREATIVE_TAB, FabricItemGroup.builder()
                .title(Component.translatable("itemGroup.CreateBB"))
                .icon(() -> CBBItems.BLUE_METH.asStack())
                .displayItems((b, output) -> {
                    for (RegistryEntry<Item> item : REGISTRATE.getAll(Registries.ITEM)) {
                        output.accept(item.get());
                    }
                })
                .build()
        );
    }
}