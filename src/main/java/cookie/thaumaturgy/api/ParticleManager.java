package cookie.thaumaturgy.api;

import cookie.thaumaturgy.entity.FXDunamis;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Global;
import net.minecraft.core.world.World;

public class ParticleManager {
	private static final Minecraft mc = Minecraft.getMinecraft(Minecraft.class);

	public static void spawnDunamisParticle(World world, double x, double y, double z, double motionX, double motionY, double motionZ, double centreX, double centreZ, double centreRadius, float R, float G, float B) {
		if (Global.isServer) return;
		mc.effectRenderer.addEffect(new FXDunamis(world, x, y, z, motionX, motionY, motionZ, centreX, centreZ, centreRadius, R, G, B));
	}
}
