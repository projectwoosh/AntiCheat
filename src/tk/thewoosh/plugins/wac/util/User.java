package tk.thewoosh.plugins.wac.util;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class User {

	private final Player player;
	public double oldY = 0; 
	public boolean wasGoingUp = false;
	private ArrayList<Long> hits = new ArrayList<>();
	private HashMap<Long, Integer> entities = new HashMap<>();
	
	private long lastTimeHitsCleaned = 0, lastTimeEntitiesCleaned = 0;
	
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
		lastTimeHitsCleaned = start;
		return result;
	}
	
	public void addEntity(int i) {
		entities.put(System.currentTimeMillis(), i);
	}
	
	public int getEntities() {
		long start = System.currentTimeMillis();
		ArrayList<Long> toRemove = new ArrayList<>(); 
		ArrayList<Integer> res = new ArrayList<>(); 
		int result = 0;
		for (long l : entities.keySet()) {
			int entityId = entities.get(l);
			if (start - l > 1000L)
				toRemove.add(l);
			else if (!res.contains(entityId)) {
				result++;
				res.add(entityId);
			}
		}
		hits.removeAll(toRemove);
		toRemove.clear();
		res.clear();
		lastTimeEntitiesCleaned = start;
		return result;
	}
	
	public long getLastTimeHitsCleaned() {
		return lastTimeHitsCleaned;
	}
	
	public long getLastTimeEntitiesCleaned() {
		return lastTimeEntitiesCleaned;
	}
	
}
