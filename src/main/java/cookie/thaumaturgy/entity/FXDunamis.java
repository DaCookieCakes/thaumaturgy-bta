package cookie.thaumaturgy.entity;

import net.minecraft.client.entity.fx.EntityFX;
import net.minecraft.client.render.Tessellator;
import net.minecraft.core.world.World;
import org.lwjgl.opengl.GL11;
import turniplabs.halplibe.helper.TextureHelper;

import static cookie.thaumaturgy.Thaumaturgy.MOD_ID;

public class FXDunamis extends EntityFX {
	double centreX;
	double centreZ;
	double centreRadius;

	public FXDunamis(World world, double x, double y, double z, double motionX, double motionY, double motionZ, double centreX, double centreZ, double centreRadius, float R, float G, float B) {
		super(world, x, y, z, motionX, motionY, motionZ);
		setSize(0.5f, 0.5f);

		particleTextureIndex = TextureHelper.getOrCreateParticleTextureIndex(MOD_ID, "dunamis.png");

		this.centreX = centreX;
		this.centreZ = centreZ;
		this.centreRadius = centreRadius;

		particleRed = R;
		particleGreen = G;
		particleBlue = B;
	}

	@Override
	public void tick() {
		super.tick();

		xo = x;
		yo = y;
		zo = z;

		if (particleAge >= particleMaxAge) remove();

		yd = 0.0;

		x = centreX + centreRadius * Math.cos(2 * Math.PI * ((double) tickCount / 20) / particleAge);
		z = centreZ + centreRadius * Math.sin(2 * Math.PI * ((double) tickCount / 20) / particleAge);

		move(xd * 0.75, yd, zd * 0.75);
	}
}
