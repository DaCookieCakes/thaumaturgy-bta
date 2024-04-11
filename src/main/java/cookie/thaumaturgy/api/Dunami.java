package cookie.thaumaturgy.api;

import java.util.ArrayList;
import java.util.List;

public class Dunami {
	// Unofficial plural (not actual greek) of Dunamis.
	public static final List<Dunamis> DUNAMI = new ArrayList<>();

	public static final Dunamis AIR = new DunamisBuilder("Air")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis EARTH = new DunamisBuilder("Earth")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis FIRE = new DunamisBuilder("Fire")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis WATER = new DunamisBuilder("Water")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis ORDER = new DunamisBuilder("Order")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static final Dunamis CHAOS = new DunamisBuilder("Chaos")
		.setColor(-1)
		.setTexture(0)
		.build();

	public static void initializeDunami() {

	}
}
