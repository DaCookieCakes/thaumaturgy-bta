package cookie.thaumaturgy;

import turniplabs.halplibe.helper.TextureHelper;

import static cookie.thaumaturgy.Thaumaturgy.MOD_ID;

public class ThaumParticles {
	protected static int particleTextureDunamis;

	public static void initializeParticles() {
		particleTextureDunamis = TextureHelper.getOrCreateParticleTextureIndex(MOD_ID, "dunamis.png");
	}
}
