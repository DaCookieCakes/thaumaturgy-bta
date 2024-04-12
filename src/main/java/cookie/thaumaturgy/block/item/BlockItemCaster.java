package cookie.thaumaturgy.block.item;

import cookie.thaumaturgy.api.DunamisStack;
import cookie.thaumaturgy.api.ParticleManager;
import cookie.thaumaturgy.block.BlockIris;
import cookie.thaumaturgy.block.entity.TileEntityIris;
import cookie.thaumaturgy.entity.FXDunamis;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class BlockItemCaster extends BlockItemNonplaceable {
	public BlockItemCaster(Block block) {
		super(block);
		setMaxStackSize(1);
	}

	// TODO this
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.addChatMessage("CASTS SPELL");
		return stack;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		if (!world.isClientSide) {
			if (player != null && world.getBlock(blockX, blockY, blockZ) instanceof BlockIris) {
				TileEntityIris tileEntity = (TileEntityIris) world.getBlockTileEntity(blockX, blockY, blockZ);
				I18n i18n = I18n.getInstance();

				for (DunamisStack dunami : tileEntity.getDunami()) {
					if (dunami.amount > 0) {
						player.addChatMessage(i18n.translateKey(dunami.getDunamis().getTranslatedName() + " : " + dunami.amount));

						double randX = world.rand.nextDouble() + blockX;
						double randY = world.rand.nextDouble() + blockY;
						double randZ = world.rand.nextDouble() + blockZ;

						for (int i = 0; i < 16; i++) {

							ParticleManager.spawnDunamisParticle(
								world,
								randX,
								randY,
								randZ,
								0.0,
								0.0,
								0.0,
								blockX,
								blockZ,
								0.0f,
								dunami.getDunamis().getR(),
								dunami.getDunamis().getG(),
								dunami.getDunamis().getB()
							);
						}
					}
				}
			}
		}

		return true;
	}
}
