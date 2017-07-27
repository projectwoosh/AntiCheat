package tk.thewoosh.plugins.wac.checks.combat;

import org.bukkit.entity.Entity;

import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.CheckType;
import tk.thewoosh.plugins.wac.util.Settings;
import tk.thewoosh.plugins.wac.util.User;

public class HitSpeed {

	private static final CheckResult PASS = new CheckResult(false, CheckType.HITSPEED, "");
	
	public static CheckResult runCheck(User user, Entity entity) {
		user.addHit();
		int hits = user.getHits();
		
		user.getPlayer().sendMessage("Hits: " + hits);
		
		if (hits > Settings.COMBAT_MAX_CPS)
			return new CheckResult(true, CheckType.HITSPEED, "tried to hit " + user.getHits() + " times per second!");
		return PASS;
	}

}
