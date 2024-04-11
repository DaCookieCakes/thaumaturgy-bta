package cookie.thaumaturgy.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.IBonemealable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockFibrousTaint extends Block implements IBonemealable {

	public BlockFibrousTaint(String key, int id, Material material) {
		super(key, id, material);
		setTicking(true);
		this.setBlockBounds(0.0f, -0.85f, 0.0f, 1.0f, 0.15f, 1.0f);
	}

	private void spreadRandomly(World world, int x, int y, int z, Random random) {
		switch (random.nextInt(4)) {
			default:
			case 0:
				if (world.isAirBlock(x + 1, y, z))
					world.setBlockWithNotify(x + 1, y, z, ThaumBlocks.FIBROUS_TAINT.id);
				break;
			case 1:
				if (world.isAirBlock(x - 1, y, z))
					world.setBlockWithNotify(x - 1, y, z, ThaumBlocks.FIBROUS_TAINT.id);
				break;
			case 2:
				if (world.isAirBlock(x, y, z + 1))
					world.setBlockWithNotify(x, y, z + 1, ThaumBlocks.FIBROUS_TAINT.id);
				break;
			case 3:
				if (world.isAirBlock(x, y, z - 1))
					world.setBlockWithNotify(x, y, z - 1, ThaumBlocks.FIBROUS_TAINT.id);
				break;
		}
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isClientSide) {
			if (world.areBlocksLoaded(x, y, z, 16) && rand.nextInt(4) == 0) {
				spreadRandomly(world, x, y, z, rand);
			}
		}
	}


	@Override
	public boolean onBonemealUsed(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, Side side, double d, double e) {
		if (!world.isClientSide) {
			itemStack.consumeItem(player);
			spreadRandomly(world, x, y, z, world.rand);
		}

		return true;
	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean collidesWithEntity(Entity entity) {
		return false;
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{};
	}
}
