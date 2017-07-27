package tk.thewoosh.plugins.wac.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import tk.thewoosh.plugins.wac.WAC;
import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.combat.Reach;
import tk.thewoosh.plugins.wac.checks.combat.WallHit;
import tk.thewoosh.plugins.wac.util.User;

public class CombatListener implements Listener {

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player player = (Player) e.getDamager();
			User user = WAC.getUser(player);
			
			CheckResult reach = Reach.runCheck(user, e.getEntity());
			
			if (reach.failed()) {
				e.setCancelled(true); // Remove this line for silent checks
				WAC.log(user, reach);
				return;
			}
			
			CheckResult wallHit = WallHit.runCheck(user, e.getEntity()); 
			
			if (wallHit.failed()) {
				e.setCancelled(true); // Remove this line for silent checks
				WAC.log(user, wallHit);
				return;
			}
		}
	}
	
}
