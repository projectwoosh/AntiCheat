package tk.thewoosh.plugins.wac.checks;

public enum CheckType {

	GLIDE("Glide"), 
	REACH("Reach"),
	WALLHIT("WallHit"),
	HITSPEED("HitSpeed"),
	MULTIAURA("MultiAura"); 
	
	private String string;
	
	private CheckType(String string) {
		this.string = string;
	}
	
	public String getName() {
		return string;
	}
	
}
