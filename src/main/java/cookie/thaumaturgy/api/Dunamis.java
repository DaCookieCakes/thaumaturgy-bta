package cookie.thaumaturgy.api;

import net.minecraft.core.lang.I18n;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static cookie.thaumaturgy.Thaumaturgy.MOD_ID;

public class Dunamis {
	protected final String MOD_ID;
	protected final String name;
	protected final int color;
	protected final int texture;
	protected final List<Dunamis> composition;

	public Dunamis(String MOD_ID, String name, int color, int texture, @Nullable List<Dunamis> composition) {
		this.MOD_ID = MOD_ID;
		this.name = name;
		this.color = color;
		this.texture = texture;
		this.composition = composition != null ? composition : new ArrayList<>();
	}

	public Dunamis(String MOD_ID, String name, int color, int texture) {
		this(MOD_ID, name, color, texture, null);
	}

	public String getName() {
		return name;
	}

	public int getColor() {
		return color;
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
