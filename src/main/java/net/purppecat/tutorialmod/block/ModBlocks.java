package net.purppecat.tutorialmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.purppecat.tutorialmod.TutorialMod;
import net.purppecat.tutorialmod.block.Custom.BismuthLampBlock;
import net.purppecat.tutorialmod.block.Custom.MagicBlock;
import net.purppecat.tutorialmod.init.ModItems;
import net.purppecat.tutorialmod.sound.ModSounds;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TutorialMod.MOD_ID);

    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock("bismuth_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(2f).noLootTable().sound(ModSounds.MAGIC_BLOCK_SOUNDS)
            ));

    public static final DeferredBlock<StairBlock> BISMUTH_STAIRS = registerBlock("bismuth_stairs",
            () -> new StairBlock(ModBlocks.BISMUTH_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<SlabBlock> BISMUTH_SLAB = registerBlock("bismuth_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<PressurePlateBlock> BISMUTH_PRESSURE_PLATE = registerBlock("bismuth_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<ButtonBlock> BISMUTH_BUTTON = registerBlock("bismuth_button",
            () -> new ButtonBlock(BlockSetType.IRON, 20,
                    BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops().noCollission()));
    public static final DeferredBlock<FenceBlock> BISMUTH_FENCE = registerBlock("bismuth_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<FenceGateBlock> BISMUTH_FENCE_GATE = registerBlock("bismuth_fence_gate",
            () -> new FenceGateBlock(WoodType.DARK_OAK, BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<WallBlock> BISMUTH_WALL = registerBlock("bismuth_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops()));
    public static final DeferredBlock<DoorBlock> BISMUTH_DOOR = registerBlock("bismuth_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops().noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> BISMUTH_TRAPDOOR = registerBlock("bismuth_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.of().sound(SoundType.AMETHYST_CLUSTER).strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BISMUTH_LAMP = registerBlock("bismuth_lamp",
            () -> new BismuthLampBlock(BlockBehaviour.Properties.of()
                    .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(BismuthLampBlock.CLICKED) ? 15 : 0)));
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
