package tk.thewoosh.plugins.wac.util;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class User {

	private final Player player;
	public double oldY = 0; 
	public boolean wasGoingUp = false;
	private ArrayList<Long> hits = new ArrayList<>();
	
	private long lastTimeCleaned = 0;
	
	public User(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void addHit() {
		hits.add(System.currentTimeMillis());
	}
	
	public int getHits() {
		long start = System.currentTimeMillis();
		ArrayList<Long> toRemove = new ArrayList<>(); 
		int result = 0;
		for (long l : hits)
			if (start - l > 1000L)
				toRemove.add(l);
			else
				result++;
		hits.removeAll(toRemove);
		toRemove.clear();
		lastTimeCleaned = start;
		return result;
	}
	
	public long getLastTimeCleaned() {
		return lastTimeCleaned;
	}
	
}
