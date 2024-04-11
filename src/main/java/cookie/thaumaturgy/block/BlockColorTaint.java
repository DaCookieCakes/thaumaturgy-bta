package cookie.thaumaturgy.block;

import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.core.world.World;

public class BlockColorTaint extends BlockColor {
	@Override
	public int getFallbackColor(int i) {
		return 0x800080;
	}

	@Override
	public int getWorldColor(World world, int i, int j, int k) {
		return 0x800080;
	}
}
