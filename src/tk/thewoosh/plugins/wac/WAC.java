package tk.thewoosh.plugins.wac;

import static org.bukkit.ChatColor.AQUA;
import static org.bukkit.ChatColor.BOLD;
import static org.bukkit.ChatColor.DARK_PURPLE;
import static org.bukkit.ChatColor.GRAY;
import static org.bukkit.ChatColor.RED;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.CheckType;
import tk.thewoosh.plugins.wac.events.CheckManager;
import tk.thewoosh.plugins.wac.events.JoinLeaveListener;
import tk.thewoosh.plugins.wac.util.Settings;
import tk.thewoosh.plugins.wac.util.User;

public class WAC extends JavaPlugin {

	public static final HashMap<UUID, User> USERS = new HashMap<>();
	public static final ArrayList<CheckType> DISABLED_CHECKS = new ArrayList<>();
	public static final boolean SIMPLE_LOG = false;

	@Override
	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new JoinLeaveListener(), this);
		pm.registerEvents(new CheckManager(), this);
		
		// 200 is the amount of ticks between cleanups. We clean things up, so the memory doesn't get overloaded etc. so 200 ticks = 10 seconds
		new Cleaner().runTaskTimerAsynchronously(this, Settings.CLEAN_UP_DELAY, Settings.CLEAN_UP_DELAY);

		for (Player p : Bukkit.getOnlinePlayers())
			WAC.USERS.put(p.getUniqueId(), new User(p));
	}
	
	public static void log(User u, CheckResult result) {
		if (DISABLED_CHECKS.contains(result.getType())) 
			throw new IllegalStateException("Error! Tried to log a disabled check!");
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
	
	public static boolean shouldCheck(User user, CheckType type) {
		// TODO Add config with disabled checks & disable checks by command
		return !DISABLED_CHECKS.contains(type);
	}
	
	public static boolean isSilent() {
		return false;
	}

}
