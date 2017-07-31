package tk.thewoosh.plugins.wac.checks.combat;

import org.bukkit.entity.Entity;

import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.CheckType;
import tk.thewoosh.plugins.wac.util.Settings;
import tk.thewoosh.plugins.wac.util.User;

public class MultiAura {

	private static final CheckResult PASS = new CheckResult(false, CheckType.MULTIAURA, "");
	
	public static CheckResult runCheck(User user, Entity entity) {
		user.addEntity(entity.getEntityId());
		int entities = user.getEntities();
		return entities > Settings.MAX_ENTITIES ? new CheckResult(true, CheckType.MULTIAURA, "tried to hit: " + entities + " different entities max(" + Settings.MAX_ENTITIES + ")") : PASS;
	}

}
