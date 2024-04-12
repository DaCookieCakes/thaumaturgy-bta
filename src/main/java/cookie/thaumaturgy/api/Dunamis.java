package cookie.thaumaturgy.api;

import net.minecraft.core.lang.I18n;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Dunamis {
	protected final String MOD_ID;
	protected final String name;
	protected final float R;
	protected final float G;
	protected final float B;
	protected final int texture;
	protected final List<Dunamis> composition;

	public Dunamis(String MOD_ID, String name, float R, float G, float B, int texture, @Nullable List<Dunamis> composition) {
		this.MOD_ID = MOD_ID;
		this.name = name;
		this.R = R;
		this.G = G;
		this.B = B;
		this.texture = texture;
		this.composition = composition != null ? composition : new ArrayList<>();
	}

	public Dunamis(String MOD_ID, String name, int R, int G, int B, int texture) {
		this(MOD_ID, name, R, G, B, texture, null);
	}

	public String getName() {
		return name;
	}

	public float getR() {
		return R;
	}

	public float getG() {
		return G;
	}

	public float getB() {
		return B;
	}

	public int getTexture() {
		return texture;
	}

	public String getTranslatedName() {
		return I18n.getInstance().translateKey(MOD_ID + ".dunamis." + name);
	}

	public List<Dunamis> getComposition() {
		return composition;
	}

	@Override
	public String toString() {
		return getName();
	}
}
