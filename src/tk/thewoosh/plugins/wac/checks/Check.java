package tk.thewoosh.plugins.wac.checks;

import org.bukkit.Bukkit;

public abstract class Check {

	protected final CheckType type;
	protected CancelType cancelType;
	
	public Check(CheckType type) {
		this.type = type;
		this.cancelType = CancelType.EVENT;
	}
	
	public CheckType getType() {
		return type;
	}
	
	public CancelType getCancelType() {
		return cancelType;
	}
	
	public void debug(Object message) {
		Bukkit.broadcastMessage(String.valueOf(message));
	}
	
}
