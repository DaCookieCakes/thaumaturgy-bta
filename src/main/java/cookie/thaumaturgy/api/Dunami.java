package cookie.thaumaturgy.api;

import java.util.ArrayList;
import java.util.List;

import static cookie.thaumaturgy.Thaumaturgy.MOD_ID;

public class Dunami {
	// Unofficial plural (not actual greek) of Dunamis.
	public static final List<Dunamis> DUNAMI = new ArrayList<>();

	public static final Dunamis AIR = new DunamisBuilder(MOD_ID)
		.setName("air")
		.setColorR(0.68f)
		.setColorG(0.85f)
		.setColorB(0.90f)
		.setTexture(0)
		.build();

	public static final Dunamis EARTH = new DunamisBuilder(MOD_ID)
		.setName("earth")
		.setColorR(0.0f)
		.setColorG(1.0f)
		.setColorB(0.0f)
		.setTexture(0)
		.build();

	public static final Dunamis FIRE = new DunamisBuilder(MOD_ID)
		.setName("fire")
		.setColorR(1.0f)
		.setColorG(0.0f)
		.setColorB(0.0f)
		.setTexture(0)
		.build();

	public static final Dunamis WATER = new DunamisBuilder(MOD_ID)
		.setName("water")
		.setColorR(0.0f)
		.setColorG(0.0f)
		.setColorB(1.0f)
		.setTexture(0)
		.build();

	public static final Dunamis ORDER = new DunamisBuilder(MOD_ID)
		.setName("order")
		.setColorR(1.0f)
		.setColorG(1.0f)
		.setColorB(1.0f)
		.setTexture(0)
		.build();

	public static final Dunamis CHAOS = new DunamisBuilder(MOD_ID)
		.setName("chaos")
		.setColorR(0.2f)
		.setColorG(0.2f)
		.setColorB(0.2f)
		.setTexture(0)
		.build();

	public static void initializeDunami() {

	}
}
