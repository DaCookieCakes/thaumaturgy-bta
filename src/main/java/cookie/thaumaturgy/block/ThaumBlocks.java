package cookie.thaumaturgy.block;

import cookie.thaumaturgy.block.entity.TileEntityNode;
import cookie.thaumaturgy.block.item.BlockItemBook;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.sound.BlockSounds;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.EntityHelper;
import useless.dragonfly.helper.ModelHelper;
import useless.dragonfly.model.block.BlockModelDragonFly;

import static cookie.thaumaturgy.Thaumaturgy.MOD_ID;

public class ThaumBlocks {
	private static int baseID = 1575;
	public static Block NODE;
	public static Block FIBROUS_TAINT;

	public static Block NONPLACEABLE_BOOK;

	public static void initializeTileEntities() {
		EntityHelper.Core.createTileEntity(TileEntityNode.class, "ThaumaturgyNode");
	}

	public static void initializeBlocks() {
		NODE = new BlockBuilder(MOD_ID)
			.setTextures("node.png")
			.setHardness(10.0F)
			.setResistance(10.0F)
			.build(new BlockNode("node", baseID++))
			.withLightEmission(0.75F);

		NONPLACEABLE_BOOK = new BlockBuilder(MOD_ID)
			.setTextures("book.png")
			.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/book.json")))
			.setItemBlock(BlockItemBook::new)
			.build(new Block("book", baseID++, Material.air));

		FIBROUS_TAINT = new BlockBuilder(MOD_ID)
			.setTextures(64, 0)
			.setBlockColor(new BlockColorTaint())
			.setBlockModel(new BlockModelRenderBlocks(24))
			.setHardness(2.0f)
			.setBlockSound(BlockSounds.GRAVEL)
			.setTags(BlockTags.MINEABLE_BY_SWORD)
			.build(new BlockFibrousTaint("fibrous_taint", baseID++, Material.dirt));
	}
}
