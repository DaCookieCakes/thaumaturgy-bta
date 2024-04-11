package cookie.thaumaturgy.item;

import com.mojang.nbt.CompoundTag;
import cookie.thaumaturgy.api.*;
import cookie.thaumaturgy.block.ThaumBlocks;
import cookie.thaumaturgy.block.entity.TileEntityNode;
import net.minecraft.core.block.Block;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import sunsetsatellite.catalyst.core.util.ICustomDescription;

import java.util.Arrays;

public class ItemWand extends Item implements ICustomDescription {

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
		if (world.getBlock(blockX, blockY, blockZ) == Block.bookshelfPlanksOak) {
			player.swingItem();

			// Spawn a 'Thaumaturgy and You' book at the bookshelf.
			EntityItem item = new EntityItem(world, blockX, blockY, blockZ, new ItemStack(ThaumBlocks.NONPLACEABLE_BOOK));
			item.setPos(blockX, blockY + 0.5F, blockZ);
			world.entityJoinedWorld(item);

			// Then replace the bookshelf with air, and spawn some fancy particles.
			world.setBlockWithNotify(blockX, blockY, blockZ, 0);

			for (int i = 0; i < itemRand.nextInt(18) + 9; i++) {
				double randX = blockX + itemRand.nextDouble();
				double randY = blockY + itemRand.nextDouble();
				double randZ = blockZ + itemRand.nextDouble();
				world.spawnParticle("portal", randX, randY + 0.22, randZ, 0.0, 0.0, 0.0);
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
		TileEntityNode tileEntityNode = (TileEntityNode) world.getBlockTileEntity(blockX, blockY, blockZ);
		if (tileEntityNode != null && player != null) {
			ItemDunamisContainer container = ThaumaturgyAPI.getItemDunamisContainer(itemStack);
			for (int i = 0; i < Dunami.DUNAMI.size(); i++) {
				Dunamis dunamis = Dunami.DUNAMI.get(i);
				if (tileEntityNode.hasDunamis(dunamis)) {
					String particle = ThaumaturgyAPI.getParticleForDunamis(dunamis);
					world.spawnParticle(particle, blockX, blockY, blockZ, 0, 0, 0);
					int taken = tileEntityNode.takeDunamis(dunamis, 2, true);
					if (taken > 0) {
						int added = container.addDunamis(dunamis, taken, true);
						if (added == taken) {
							tileEntityNode.takeDunamis(dunamis, 2, false);
							container.addDunamis(dunamis, taken, false);
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
			lastDesc.append("\n").append(stack.getDunamis().getName()).append(" ").append(stack.amount);
		}

		return firstDesc + lastDesc;
	}
}
