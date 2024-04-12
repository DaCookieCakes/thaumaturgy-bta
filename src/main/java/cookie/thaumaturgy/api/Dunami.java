package cookie.thaumaturgy.api;

import java.util.ArrayList;
import java.util.List;

import java.awt.Color;

import static cookie.thaumaturgy.Thaumaturgy.MOD_ID;

public class Dunami {
	// Unofficial plural (not actual greek) of Dunamis.
	public static final List<Dunamis> DUNAMI = new ArrayList<>();

	public static final Dunamis AIR = new DunamisBuilder(MOD_ID)
		.setName("air")
		.setColor(new Color(173, 216, 230))
		.setTexture(0)
		.build();

	public static final Dunamis EARTH = new DunamisBuilder(MOD_ID)
		.setName("earth")
		.setColor(new Color(0, 255, 0))
		.setTexture(0)
		.build();

	public static final Dunamis FIRE = new DunamisBuilder(MOD_ID)
		.setName("fire")
		.setColor(new Color(255, 0, 0))
		.setTexture(0)
		.build();

	public static final Dunamis WATER = new DunamisBuilder(MOD_ID)
		.setName("water")
		.setColor(new Color(0, 0, 255))
		.setTexture(0)
		.build();

	public static final Dunamis ORDER = new DunamisBuilder(MOD_ID)
		.setName("order")
		.setColor(new Color(255, 255, 255))
		.setTexture(0)
		.build();

	public static final Dunamis CHAOS = new DunamisBuilder(MOD_ID)
		.setName("chaos")
		.setColor(new Color(30, 30, 30))
		.setTexture(0)
		.build();

	public static void initializeDunami() {

	}
}
