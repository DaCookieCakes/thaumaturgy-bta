package cookie.thaumaturgy.api;

import java.util.List;

public class DunamisBuilder {
	private final String MOD_ID;
	private String name;
	private int color;
	private int texture;
	private List<Dunamis> composition;

	public DunamisBuilder(String MOD_ID) {
		this.MOD_ID = MOD_ID;
	}

	public DunamisBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public DunamisBuilder setColor(int color) {
		this.color = color;
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
		Dunamis dunamis = new Dunamis(MOD_ID, name, color, texture, composition);
		Dunami.DUNAMI.add(dunamis);
		return dunamis;
	}
}
