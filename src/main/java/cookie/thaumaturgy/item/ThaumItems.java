package cookie.thaumaturgy.item;

import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.ItemHelper;

import static cookie.thaumaturgy.Thaumaturgy.MOD_ID;

public class ThaumItems {
	private static int baseID = 16575;

	public static Item WAND_BASIC;
	public static Item THAUMIC_READER;

	public static void initializeItems() {
		WAND_BASIC = ItemHelper.createItem(MOD_ID,
			new ItemWand("wand_basic", baseID++),
			"gold_capped_wooden_wand.png");

		THAUMIC_READER = ItemHelper.createItem(MOD_ID,
			new ItemThaumicReader("thaumic_reader", baseID++),
			"thaumic_reader.png");
	}
}
