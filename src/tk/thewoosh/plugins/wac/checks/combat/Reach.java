package tk.thewoosh.plugins.wac.checks.combat;

import org.bukkit.GameMode;
import org.bukkit.entity.Entity;

import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.CheckType;
import tk.thewoosh.plugins.wac.util.Distance;
import tk.thewoosh.plugins.wac.util.Settings;
import tk.thewoosh.plugins.wac.util.User;

public class Reach {

	private static final CheckResult PASS = new CheckResult(false, CheckType.REACH, "");
	
	public static CheckResult runCheck(User user, Entity entity) {
		Distance distance = new Distance(user.getPlayer().getLocation(), entity.getLocation());
		double x = distance.getXDiffrence();
		double z = distance.getZDiffrence();
		
		double max = user.getPlayer().getGameMode() == GameMode.CREATIVE ? Settings.COMBAT_MAX_REACH_CREATIVE : Settings.COMBAT_MAX_REACH_SURVIVAL;
		
		if (x > max || z > max) 
			return new CheckResult(true, CheckType.REACH, ", " + (x > z ? z > max ? "both are " : x + " is " : z + " is ") + "greather than " + max);
		
		return PASS;
	}
	
}
