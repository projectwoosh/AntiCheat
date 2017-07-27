package tk.thewoosh.plugins.wac.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import tk.thewoosh.plugins.wac.WAC;
import tk.thewoosh.plugins.wac.util.User;

public class JoinLeaveListener implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		WAC.USERS.put(e.getPlayer().getUniqueId(), new User(e.getPlayer()));
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		WAC.USERS.remove(e.getPlayer().getUniqueId());
	}
	
	
}
