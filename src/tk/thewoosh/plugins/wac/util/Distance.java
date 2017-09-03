package tk.thewoosh.plugins.wac.util;

import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

public class Distance {

	private Location to, from;
	private double xDiff, yDiff, zDiff;
	
	private boolean goingUp, goingDown;
	
	public Distance(PlayerMoveEvent e) {
		this(e.getFrom(), e.getTo());
	}
	
	public Distance(Location a, Location b) {
		this.from = a;
		this.to = b;
		
		this.xDiff = Math.abs(a.getX() - b.getX());
		this.yDiff = Math.abs(a.getY() - b.getY());
		this.zDiff = Math.abs(a.getZ() - b.getZ());
		goingUp = to.getY() > from.getY();
		goingDown = from.getY() > to.getY();
	}

	public Location getTo() {
		return to;
	}
	
	public Location getFrom() {
		return from;
	}
	
	public double getXDifference() {
		return xDiff;
	}
	
	public double getZDifference() {
		return zDiff;
	}
	
	public double getYDifference() {
		return yDiff;
	}
	
	public boolean isGoingDown() {
		return goingDown;
	}
	
	public boolean isGoingUp() {
		return goingUp;
	}

	public boolean isMovingHorizontally() {
		return xDiff != 0 || zDiff != 0;
	}
	
	
}

