package tk.thewoosh.plugins.wac;

import org.bukkit.scheduler.BukkitRunnable;

import tk.thewoosh.plugins.wac.util.User;

public class Cleaner extends BukkitRunnable {

	@Override
	public void run() {
		for (User user : WAC.USERS.values()) {
			user.getHits();
			user.getEntities();
		}
	}

}
