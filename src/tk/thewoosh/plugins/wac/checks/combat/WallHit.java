package tk.thewoosh.plugins.wac.checks.combat;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.CheckType;
import tk.thewoosh.plugins.wac.util.Distance;
import tk.thewoosh.plugins.wac.util.User;

public class WallHit {

	private static final CheckResult PASS = new CheckResult(false, CheckType.WALLHIT, "");

	public static CheckResult runCheck(User user, Entity entity) {
		System.out.println("Loaded module: WallHit");
		Distance distance = new Distance(user.getPlayer().getLocation(), entity.getLocation());
		double x = distance.getXDifference();
		double z = distance.getZDifference();
		Player p = user.getPlayer();

		if (x == 0 || z == 0) {
			System.out.println("Warning! Positions are same"); // optional
			return PASS;
		}
		
		if (distance.getYDifference() >= .6) // TODO Change .6 to height of entity / height of player
			return PASS;
		
		Location l = null;

		if (x <= .5 && z >= 1) {
			if (p.getLocation().getZ() > entity.getLocation().getZ()) {
				l = p.getLocation().clone().add(0, 0, -1);
			} else {
				l = p.getLocation().clone().add(0, 0, 1);
			}
		} else if (z <= .5 && x >= 1) {
			if (p.getLocation().getX() > entity.getLocation().getX()) {
				l = p.getLocation().clone().add(-1, 0, 0); 
			} else {
				l = p.getLocation().clone().add(-1, 0, 0);
			}
		}
		boolean failed = false;
		
		if (l != null)
			failed = l.getBlock().getType().isSolid() && l.clone().add(0, 1, 0).getBlock().getType().isSolid();
		
		return failed ? new CheckResult(true, CheckType.WALLHIT, "tried to hit"
				+ (entity.getType() != EntityType.PLAYER ? " a" : "") + " " + entity.getName() + " through a wall")
				: PASS;
	}

}
