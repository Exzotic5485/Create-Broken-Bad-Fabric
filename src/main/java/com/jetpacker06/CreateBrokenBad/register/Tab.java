package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class Tab {
    public static void register(Registrate REGISTRATE) {
        FabricItemGroupBuilder.create(new ResourceLocation(CreateBrokenBad.MOD_ID, "group"))
                .icon(() -> CBBItems.BLUE_METH.asStack())
                .appendItems(((itemStacks, creativeModeTab) -> {
                    for (RegistryEntry<Item> item : REGISTRATE.getAll(Registry.ITEM_REGISTRY)) {
                        itemStacks.add(new ItemStack(item.get()));
                    }
                }))
                .build();
    }
}