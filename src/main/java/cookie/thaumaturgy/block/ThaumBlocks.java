package cookie.thaumaturgy.block;

import cookie.thaumaturgy.block.entity.TileEntityIris;
import cookie.thaumaturgy.block.item.BlockItemBook;
import cookie.thaumaturgy.block.item.BlockItemCaster;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLog;
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
	public static Block IRIS;
	public static Block FIBROUS_TAINT;
	public static Block NONPLACEABLE_BOOK;
	public static Block NONPLACEABLE_CRUDE_CASTER;
	public static Block IRONWOOD_LOG;

	public static void initializeTileEntities() {
		EntityHelper.Core.createTileEntity(TileEntityIris.class, "ThaumaturgyNode");
	}

	public static void initializeBlocks() {
		IRIS = new BlockBuilder(MOD_ID)
			.setTextures("node.png")
			.setHardness(10.0F)
			.setResistance(10.0F)
			.build(new BlockIris("iris", baseID++))
			.withLightEmission(0.75F);

		FIBROUS_TAINT = new BlockBuilder(MOD_ID)
			.setTextures(64, 0)
			.setBlockColor(new BlockColorTaint())
			.setBlockModel(new BlockModelRenderBlocks(24))
			.setHardness(2.0f)
			.setBlockSound(BlockSounds.GRAVEL)
			.setTags(BlockTags.MINEABLE_BY_SWORD)
			.build(new BlockFibrousTaint("fibrous_taint", baseID++, Material.dirt));

		NONPLACEABLE_BOOK = new BlockBuilder(MOD_ID)
			.setTextures("book.png")
			.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/book.json")))
			.setItemBlock(BlockItemBook::new)
			.build(new Block("book", baseID++, Material.air));

		NONPLACEABLE_CRUDE_CASTER = new BlockBuilder(MOD_ID)
			.setTextures("caster_crude.png")
			.setBlockModel(new BlockModelDragonFly(ModelHelper.getOrCreateBlockModel(MOD_ID, "block/caster.json")))
			.setItemBlock(BlockItemCaster::new)
			.build(new Block("crude_caster", baseID++, Material.wood));

		IRONWOOD_LOG = new BlockBuilder(MOD_ID)
			.setTopBottomTexture("log_ironwood_topbottom.png")
			.setSideTextures("log_ironwood_sides.png")
			.setHardness(3.5F)
			.setResistance(5.0F)
			.setBlockSound(BlockSounds.METAL)
			.build(new BlockLog("ironwood_log", baseID++));
	}
}
