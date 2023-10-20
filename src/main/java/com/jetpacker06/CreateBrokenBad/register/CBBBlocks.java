package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.block.BrassCallBellBlock;
import com.jetpacker06.CreateBrokenBad.block.EphedraBlock;
import com.jetpacker06.CreateBrokenBad.block.TrayBlock;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Blocks;

public class CBBBlocks {

    public static BlockEntry<EphedraBlock> EPHEDRA_CROP_BLOCK;
    public static BlockEntry<BrassCallBellBlock> BRASS_CALL_BELL;
    public static BlockEntry<BrassCallBellBlock.Trapped> TRAPPED_BRASS_CALL_BELL;
    public static BlockEntry<TrayBlock.Blue> BLUE_METH_TRAY;
    public static BlockEntry<TrayBlock.Empty> TRAY;
    public static BlockEntry<TrayBlock.White> WHITE_METH_TRAY;

    public static void register(Registrate REGISTRATE) {
        EPHEDRA_CROP_BLOCK = REGISTRATE.block("ephedra_crop_block", EphedraBlock::new)
                .initialProperties(() -> Blocks.BEETROOTS)
                //.lang("Ephedra Crop")
                .register();
        BRASS_CALL_BELL = REGISTRATE.block("brass_call_bell", BrassCallBellBlock::new)
                .simpleItem()
                //.lang("Brass Call Bell")
                .register();
        TRAPPED_BRASS_CALL_BELL = REGISTRATE.block("trapped_brass_call_bell", BrassCallBellBlock.Trapped::new)
                .simpleItem()
                //.lang("Trapped Brass Call Bell")
                .register();
        BLUE_METH_TRAY = REGISTRATE.block("blue_meth_tray", TrayBlock.Blue::new)
                .simpleItem()
                //.lang("Blue Meth Tray")
                .register();
        TRAY = REGISTRATE.block("tray", TrayBlock.Empty::new)
                .simpleItem()
                //.lang("Tray")
                .register();
        WHITE_METH_TRAY = REGISTRATE.block("white_meth_tray", TrayBlock.White::new)
                .simpleItem()
                //.lang("White Meth Tray")
                .register();}
}
