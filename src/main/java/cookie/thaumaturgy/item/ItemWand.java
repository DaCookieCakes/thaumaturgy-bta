package cookie.thaumaturgy.item;

import com.mojang.nbt.CompoundTag;
import cookie.thaumaturgy.api.*;
import cookie.thaumaturgy.block.ThaumBlocks;
import cookie.thaumaturgy.block.entity.TileEntityIris;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.core.util.ICustomDescription;

import java.util.HashMap;

public class ItemWand extends Item implements ICustomDescription {
	public static HashMap<Block, ItemStack> taintInfuseMap = new HashMap<>();

	public ItemWand(String name, int id) {
		super(name, id);
		this.setFull3D();
		this.maxStackSize = 1;
	}

	@Override
	public CompoundTag getDefaultTag() {
		CompoundTag tag = new CompoundTag();
		tag.put("dunami", new CompoundTag());
		return tag;
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		// First get the targeted block and check to see if it's in the hashmap.
		Block blockToGet = world.getBlock(blockX, blockY, blockZ);

		if (taintInfuseMap.containsKey(blockToGet)) {
			player.swingItem();

			// If it passes then get the itemstack tied to it
			// and spawn it in the block's place.
			ItemStack stackToSpawn = new ItemStack(taintInfuseMap.get(blockToGet));

			EntityItem item = new EntityItem(world, blockX, blockY, blockZ, stackToSpawn);
			item.setPos(blockX, blockY + 0.5F, blockZ);
			world.entityJoinedWorld(item);

			// Then replace the block with air, and spawn some 'fancy' particles.
			world.setBlockWithNotify(blockX, blockY, blockZ, 0);

			for (int i = 0; i < itemRand.nextInt(18) + 9; i++) {
				double randX = blockX + itemRand.nextDouble();
				double randY = blockY + itemRand.nextDouble();
				double randZ = blockZ + itemRand.nextDouble();
				world.spawnParticle("flame", randX, randY + 0.22, randZ, 0.0, 0.2, 0.0);
			}

			for (int i = 0; i < 3; i++) {
				double randX = blockX + itemRand.nextDouble();
				double randY = blockY + itemRand.nextDouble();
				double randZ = blockZ + itemRand.nextDouble();
				world.spawnParticle("explode", randX, randY + 0.22, randZ, 0.0, 0.1, 0.0);
			}
			return true;
		}

		// Check if the node and player aren't null. If it passes, lower the node count and raise the player's mana.
		TileEntityIris tileEntityNode = (TileEntityIris) world.getBlockTileEntity(blockX, blockY, blockZ);
		if (tileEntityNode != null && player != null) {
			ItemDunamisContainer container = ThaumaturgyAPI.getItemDunamisContainer(itemStack);
			for (int i = 0; i < Dunami.DUNAMI.size(); i++) {
				Dunamis dunamis = Dunami.DUNAMI.get(i);
				if (tileEntityNode.hasDunamis(dunamis)) {
					int taken = tileEntityNode.takeDunamis(dunamis, 2, true);

					if (taken > 0) {
						int added = container.addDunamis(dunamis, taken, true);

						if (added == taken) {
							tileEntityNode.takeDunamis(dunamis, 2, false);
							container.addDunamis(dunamis, taken, false);
						}
					}

					for (DunamisStack dunami : tileEntityNode.getDunami()) {
						if (dunami.amount > 0) {
							double randX = world.rand.nextDouble() + blockX;
							double randY = world.rand.nextDouble() + blockY;
							double randZ = world.rand.nextDouble() + blockZ;

							for (int j = 0; j < 1; j++) {
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
									dunami.getDunamis().getColor()
								);
							}
						}
					}

				}
			}
			container.save();
			return true;
		}
		return false;
	}

	@Override
	public String getDescription(ItemStack itemStack) {
		I18n i18n = I18n.getInstance();
		String firstDesc = "§125 " + i18n.translateDescKey("item.thaumaturgy.wand.charge");
		StringBuilder lastDesc = new StringBuilder();

		ItemDunamisContainer container = ThaumaturgyAPI.getItemDunamisContainer(itemStack);

		for (DunamisStack stack : container.getDunami()) {
			lastDesc.append("\n").append(stack.getDunamis().getTranslatedName()).append(" ").append(stack.amount);
		}

		return firstDesc + lastDesc;
	}

	static {
		taintInfuseMap.put(Block.bookshelfPlanksOak, new ItemStack(ThaumBlocks.NONPLACEABLE_BOOK));
		taintInfuseMap.put(ThaumBlocks.IRONWOOD_LOG, new ItemStack(ThaumBlocks.NONPLACEABLE_CRUDE_CASTER));
	}
}
