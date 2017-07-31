package tk.thewoosh.plugins.wac.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import tk.thewoosh.plugins.wac.WAC;
import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.CheckType;
import tk.thewoosh.plugins.wac.checks.movement.Glide;
import tk.thewoosh.plugins.wac.util.Distance;
import tk.thewoosh.plugins.wac.util.User;

public class MoveListener implements Listener {

	@EventHandler
	public void onJoin(PlayerMoveEvent e) {
		User user = WAC.getUser(e.getPlayer());
		Distance distance = new Distance(e);
		if (WAC.shouldCheck(user, CheckType.GLIDE)) {
			CheckResult glide = Glide.runCheck(user, distance);
			if (glide.failed()) {
				WAC.log(user, glide);
				e.setTo(e.getFrom());
				// TODO: Bring to ground
			}
		}
	}
	
}
