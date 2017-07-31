package tk.thewoosh.plugins.wac.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import tk.thewoosh.plugins.wac.WAC;
import tk.thewoosh.plugins.wac.checks.CheckResult;
<<<<<<< HEAD
import tk.thewoosh.plugins.wac.checks.CheckType;
import tk.thewoosh.plugins.wac.checks.combat.HitSpeed;
import tk.thewoosh.plugins.wac.checks.combat.MultiAura;
=======
>>>>>>> 54406f919c9ea598d52b4760e03bde17183c56d9
import tk.thewoosh.plugins.wac.checks.combat.Reach;
import tk.thewoosh.plugins.wac.checks.combat.WallHit;
import tk.thewoosh.plugins.wac.util.User;

public class CombatListener implements Listener {

	@EventHandler
	public void onDamage(EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			Player player = (Player) e.getDamager();
			User user = WAC.getUser(player);

			if (WAC.shouldCheck(user, CheckType.REACH)) {
				CheckResult reach = Reach.runCheck(user, e.getEntity());
				if (reach.failed()) {
					e.setCancelled(true); // Remove this line for silent checks
					WAC.log(user, reach);
					return;
				}
			}

			if (WAC.shouldCheck(user, CheckType.WALLHIT)) {
				CheckResult wallHit = WallHit.runCheck(user, e.getEntity());
				if (wallHit.failed()) {
					e.setCancelled(true); // Remove this line for silent checks
					WAC.log(user, wallHit);
					return;
				}

			}
			if (WAC.shouldCheck(user, CheckType.HITSPEED)) {
				CheckResult hitSpeed = HitSpeed.runCheck(user, e.getEntity());
				if (hitSpeed.failed()) {
					e.setCancelled(true); // Remove this line for silent checks
					WAC.log(user, hitSpeed);
					return;
				}
			}
<<<<<<< HEAD

			if (WAC.shouldCheck(user, CheckType.MULTIAURA)) {
				CheckResult multiAura = MultiAura.runCheck(user, e.getEntity());
				if (multiAura.failed()) {
					e.setCancelled(true); // Remove this line for silent checks
					WAC.log(user, multiAura);
					return;
				}
			}
=======
>>>>>>> 54406f919c9ea598d52b4760e03bde17183c56d9
		}
	}

}
