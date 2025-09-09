package net.xelafree.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.xelafree.tutorialmod.TutorialMod;

/**
 * Registers all of the modded items.
 */
public class ModItems {
	public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
	public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

	
	/**
	 * The helper method that actually registers items into the game.
	 * 
	 * @param name name of the item to be registered
	 * @param item item object for the item
	 * @return returns the item object if succsefuly registered
	 */
	private static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
	}

	/**
	 * Handles the registration of items and grouping those items.
	 */
	public static void registerModItems() {
		TutorialMod.LOGGER.info("Registering mod items for " + TutorialMod.MOD_ID);
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
			entries.add(PINK_GARNET);
			entries.add(RAW_PINK_GARNET);
		});
	}
}
