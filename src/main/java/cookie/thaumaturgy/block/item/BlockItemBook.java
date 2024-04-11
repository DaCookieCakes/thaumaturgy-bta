package cookie.thaumaturgy.block.item;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockItemBook extends BlockItemNonplaceable{
	public BlockItemBook(Block block) {
		super(block);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		player.addChatMessage("BOOK.");
		return itemstack;
	}
}
