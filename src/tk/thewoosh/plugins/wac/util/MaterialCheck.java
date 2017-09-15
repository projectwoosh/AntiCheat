package tk.thewoosh.plugins.wac.util;

import org.bukkit.Location;
import org.bukkit.Material;

public abstract class MaterialCheck {

	public final boolean checkMaterial(Location location) {
		return checkMaterial(location.getBlock().getType());
	}

	public abstract boolean checkMaterial(Material material);
	
}
