package cookie.thaumaturgy.api;

import java.util.ArrayList;
import java.util.List;

import static cookie.thaumaturgy.Thaumaturgy.MOD_ID;

public class Dunami {
	// Unofficial plural (not actual greek) of Dunamis.
	public static final List<Dunamis> DUNAMI = new ArrayList<>();

	public static final Dunamis AIR = new DunamisBuilder(MOD_ID)
		.setName("air")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis EARTH = new DunamisBuilder(MOD_ID)
		.setName("earth")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis FIRE = new DunamisBuilder(MOD_ID)
		.setName("fire")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis WATER = new DunamisBuilder(MOD_ID)
		.setName("water")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis ORDER = new DunamisBuilder(MOD_ID)
		.setName("order")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis CHAOS = new DunamisBuilder(MOD_ID)
		.setName("chaos")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static void initializeDunami() {

	}
}
