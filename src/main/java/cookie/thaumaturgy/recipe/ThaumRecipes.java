package cookie.thaumaturgy.recipe;

import cookie.thaumaturgy.block.ThaumBlocks;
import cookie.thaumaturgy.item.ThaumItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import static cookie.thaumaturgy.Thaumaturgy.MOD_ID;

public class ThaumRecipes implements RecipeEntrypoint {
	@Override
	public void onRecipesReady() {
		Registries.ITEM_GROUPS.register(MOD_ID + ":logs", Registries.stackListOf(Block.logBirch, Block.logCherry, Block.logEucalyptus, Block.logOak, Block.logOakMossy, Block.logPine));

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("  1", " 2 ", "1  ")
			.addInput('1', Item.ingotGold)
			.addInput('2', Item.stick)
			.create("iron_capped_wooden_wand", new ItemStack(ThaumItems.WAND_BASIC));

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(Item.ingotIron)
			.addInput("thaumaturgy:logs")
			.create("ironwood_log", new ItemStack(ThaumBlocks.IRONWOOD_LOG));

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(ThaumBlocks.IRONWOOD_LOG)
			.create("ironwood_log_to_gray_planks", new ItemStack(Block.planksOakPainted, 4, 7));
	}

	@Override
	public void initNamespaces() {
		RecipeNamespace namespace = new RecipeNamespace();
		namespace.register("workbench", Registries.RECIPES.WORKBENCH);
		Registries.RECIPES.register(MOD_ID, namespace);
	}
}
