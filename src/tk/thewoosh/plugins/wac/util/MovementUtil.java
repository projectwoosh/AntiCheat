package tk.thewoosh.plugins.wac.util;

import org.bukkit.Location;
import org.bukkit.Material;

public class MovementUtil {

	public static final double PLAYER_WIDTH = .6;
	public static final double PLAYER_HEIGTH = 1.8;
	public static final double PLAYER_HEIGTH_SNEAKING = 1.6;
	
	/**
	 * This returns if the player should be flagged 
	 * @return true if the player is now on ground or if the player is on a vine or on a ladder (Liquids?)
	 * */
	public static boolean shouldNotFlag(Location loc) {
		return isMaterialGlideable(loc.getBlock().getType())
				|| isMaterialGlideable(loc.clone().add(PLAYER_WIDTH/2, 0, 0).getBlock().getType())
				|| isMaterialGlideable(loc.clone().add(PLAYER_WIDTH/2, 0, PLAYER_WIDTH/2).getBlock().getType())
				|| isMaterialGlideable(loc.clone().add(PLAYER_WIDTH/2, 0, -PLAYER_WIDTH/2).getBlock().getType())
				|| isMaterialGlideable(loc.clone().add(-PLAYER_WIDTH/2, 0, 0).getBlock().getType())
				|| isMaterialGlideable(loc.clone().add(-PLAYER_WIDTH/2, 0, -PLAYER_WIDTH/2).getBlock().getType())
				|| isMaterialGlideable(loc.clone().add(0, 0, -PLAYER_WIDTH/2).getBlock().getType())
				|| isMaterialGlideable(loc.clone().add(0, 0, PLAYER_WIDTH/2).getBlock().getType()) 
				|| isOnGround(loc.clone().add(0, 0, 0));

	}

	public static boolean isOnGround(Location loc) {
		return loc.getBlock().getLocation().clone().add(0, -1, 0).getBlock().getType().isSolid() || loc.clone().add(PLAYER_WIDTH/2, -1,0).getBlock().getType().isSolid()
				|| loc.clone().add(PLAYER_WIDTH/2, -1, PLAYER_WIDTH/2).getBlock().getType().isSolid()
				|| loc.clone().add(PLAYER_WIDTH/2, -1, -PLAYER_WIDTH/2).getBlock().getType().isSolid()
				|| loc.clone().add(-PLAYER_WIDTH/2, -1, 0).getBlock().getType().isSolid()
				|| loc.clone().add(-PLAYER_WIDTH/2, -1,-PLAYER_WIDTH/2).getBlock().getType().isSolid()
				|| loc.clone().add(0, -1,-PLAYER_WIDTH/2).getBlock().getType().isSolid()
				|| loc.clone().add(0, -1, PLAYER_WIDTH/2).getBlock().getType().isSolid();
	}

	public static boolean isMaterialGlideable(Material mat) {
		// TODO Add liquids 
		switch (mat) {
		case LADDER:
		case VINE:
			return true;
		default:
			return false;
		}
	}

}
