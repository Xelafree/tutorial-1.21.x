package net.xelafree.tutorialmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.xelafree.tutorialmod.TutorialMod;

/**
 * Registers the blocks for the mod.
 */
public class ModBlocks {

	public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block", new Block(
			AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

	public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block", new Block(
			AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE)));

	/**
	 * Helper that adds the specified block to the block registry.
	 * 
	 * @param name  name of the block to be registered
	 * @param block the block to be registered
	 * @return returns the Block if registration is successful.
	 */
	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
	}

	/**
	 * Helper method that registers a block item to the item registry.
	 * 
	 * @param name  name of the item
	 * @param block the block to be registered
	 */
	private static void registerBlockItem(String name, Block block) {
		Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
				new BlockItem(block, new Item.Settings()));
	}

	/**
	 * Weird little initializer.
	 * 
	 * Also adds the blocks to their respective ItemGroups.
	 */
	public static void registerModBlocks() {
		TutorialMod.LOGGER.info("Registering mod blocks for " + TutorialMod.MOD_ID);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
			entries.add(ModBlocks.PINK_GARNET_BLOCK);
			entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
		});
	}
}
