package tk.thewoosh.plugins.wac;

import java.util.HashMap;

import static org.bukkit.ChatColor.*;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.events.CombatListener;
import tk.thewoosh.plugins.wac.events.JoinLeaveListener;
import tk.thewoosh.plugins.wac.events.MoveListener;
import tk.thewoosh.plugins.wac.util.User;

public class WAC extends JavaPlugin {

	public static final HashMap<UUID, User> USERS = new HashMap<>();

	public static final boolean SIMPLE_LOG = false;

	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinLeaveListener(), this);
		pm.registerEvents(new MoveListener(), this);
		pm.registerEvents(new CombatListener(), this);
		
		new Cleaner().runTaskTimerAsynchronously(this, 0, 20);

		for (Player p : Bukkit.getOnlinePlayers())
			WAC.USERS.put(p.getUniqueId(), new User(p));
	}
	
	public static void log(User u, CheckResult result) {
		String message = DARK_PURPLE.toString() + BOLD + "WAC: " + AQUA.toString() + u.getPlayer().getName() + GRAY + " tried to use " + RED + result.getType().getName();
		if (!SIMPLE_LOG)
			message += GRAY + ", " + result.getMessage();
		u.getPlayer().sendMessage(message);
		Bukkit.getLogger().info(message);
	}

	public static User getUser(Player player) {
		for (User user : USERS.values())
			if (user.getPlayer() == player || user.getPlayer().getUniqueId().equals(player.getUniqueId()))
				return user;
		return null;
	}

}
