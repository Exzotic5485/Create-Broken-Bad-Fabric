package com.jetpacker06.CreateBrokenBad.register;

import com.jetpacker06.CreateBrokenBad.block.BrassCallBellBlockEntity;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;

public class CBBBlockEntityTypes {

    public static BlockEntityEntry<BrassCallBellBlockEntity> BRASS_CALL_BELL;

    public static void register(Registrate REGISTRATE) {
        BRASS_CALL_BELL = REGISTRATE
                .blockEntity("brass_call_bell", BrassCallBellBlockEntity::new)
                .validBlocks(CBBBlocks.BRASS_CALL_BELL, CBBBlocks.TRAPPED_BRASS_CALL_BELL)
                .register();
    }
}
