package com.jetpacker06.CreateBrokenBad.register;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

public class VillagerTrades {
    public static void register() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add(((trader, random) -> new MerchantOffer(
                            new ItemStack(Items.EMERALD, 2),
                            new ItemStack(CBBItems.EPHEDRA.get(), 8),
                            10, 8, 0.02F)));
                });

        registerDefaultTrades(VillagerProfession.FARMER);
        registerDefaultTrades(VillagerProfession.ARMORER);
        registerDefaultTrades(VillagerProfession.BUTCHER);
        registerDefaultTrades(VillagerProfession.CLERIC);
        registerDefaultTrades(VillagerProfession.CARTOGRAPHER);
        registerDefaultTrades(VillagerProfession.FISHERMAN);
        registerDefaultTrades(VillagerProfession.FLETCHER);
        registerDefaultTrades(VillagerProfession.LEATHERWORKER);
        registerDefaultTrades(VillagerProfession.LIBRARIAN);
        registerDefaultTrades(VillagerProfession.MASON);
        registerDefaultTrades(VillagerProfession.NITWIT);
    }

    private static void registerDefaultTrades(VillagerProfession profession) {
        TradeOfferHelper.registerVillagerOffers(profession, 2,
                factories -> {
                    factories.add(((trader, random) -> new MerchantOffer(
                            new ItemStack(CBBItems.WHITE_METH.get()),
                            new ItemStack(Items.EMERALD, 2),
                            10, 8, 0.02F)));
                });

        TradeOfferHelper.registerVillagerOffers(profession, 3,
                factories -> {
                    factories.add(((trader, random) -> new MerchantOffer(
                            new ItemStack(CBBItems.BLUE_METH.get()),
                            new ItemStack(Items.EMERALD, 3),
                            10, 8, 0.02F)));
                });
    }
}
