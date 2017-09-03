package tk.thewoosh.plugins.wac.events;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import tk.thewoosh.plugins.wac.WAC;
import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.MoveCheck;
import tk.thewoosh.plugins.wac.checks.movement.Glide;
import tk.thewoosh.plugins.wac.checks.movement.NormalMovements;
import tk.thewoosh.plugins.wac.util.Distance;
import tk.thewoosh.plugins.wac.util.User;

public class CheckManager implements Listener {

	private ArrayList<MoveCheck> moveChecks;

	public CheckManager() {
		moveChecks = new ArrayList<>();
		String splitter = "+==============+===============+";
		Bukkit.getLogger().info(splitter);
		Bukkit.getLogger().info("\t\tWAC");
		Bukkit.getLogger().info(splitter);
		Bukkit.getLogger().info("\tVersion: " + WAC.getPlugin(WAC.class).getDescription().getVersion());
		Bukkit.getLogger().info("\tAuthor: Tristan");
		Bukkit.getLogger().info(splitter);
		Bukkit.getLogger().info(" ");
		Bukkit.getLogger().info(splitter);
		Bukkit.getLogger().info("\t   Check Manager");
		Bukkit.getLogger().info(splitter);
		Bukkit.getLogger().info("\tMovement Checks:");
		addCheck(new Glide());
		addCheck(new NormalMovements());
		// And all other checks
		Bukkit.getLogger().info(splitter);
	}

	private void addCheck(MoveCheck moveCheck) {
		moveChecks.add(moveCheck);
		Bukkit.getLogger().info("\t" + moveCheck.getType().getName() + " has been enabled.");
	}

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		User user = WAC.getUser(e.getPlayer());
		Distance distance = new Distance(e);
		for (MoveCheck check : moveChecks)
			if (WAC.shouldCheck(user, check.getType())) {
				CheckResult result = check.runCheck(user, distance);
				if (result.failed()) {
					WAC.log(user, result);
					switch (check.getCancelType()) {
					case EVENT:
						e.setTo(e.getFrom());
						break;
					case PULLDOWN:

						break;
					default:
						break;
					}
				}
			}
	}

}
