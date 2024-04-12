package cookie.thaumaturgy.api;

import java.util.List;

public class DunamisBuilder {
	private final String MOD_ID;
	private String name;
	private float colorR;
	private float colorG;
	private float colorB;
	private int texture;
	private List<Dunamis> composition;

	public DunamisBuilder(String MOD_ID) {
		this.MOD_ID = MOD_ID;
	}

	public DunamisBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public DunamisBuilder setColorR(float value) {
		this.colorR = value;
		return this;
	}

	public DunamisBuilder setColorG(float value) {
		this.colorG = value;
		return this;
	}

	public DunamisBuilder setColorB(float value) {
		this.colorB = value;
		return this;
	}

	public DunamisBuilder setTexture(int texture) {
		this.texture = texture;
		return this;
	}

	public DunamisBuilder setComposition(List<Dunamis> composition) {
		this.composition = composition;
		return this;
	}

	public Dunamis build() {
		Dunamis dunamis = new Dunamis(MOD_ID, name, colorR, colorG, colorB, texture, composition);
		Dunami.DUNAMI.add(dunamis);
		return dunamis;
	}
}
