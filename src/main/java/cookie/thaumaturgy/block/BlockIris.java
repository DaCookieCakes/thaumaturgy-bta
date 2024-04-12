package cookie.thaumaturgy.block;

import cookie.thaumaturgy.block.entity.TileEntityIris;
import net.minecraft.core.block.BlockTileEntity;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;

public class BlockIris extends BlockTileEntity {
	public BlockIris(String key, int id) {
		super(key, id, Material.air);
	}

	@Override
	protected TileEntity getNewBlockEntity() {
		return new TileEntityIris();
	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
}
