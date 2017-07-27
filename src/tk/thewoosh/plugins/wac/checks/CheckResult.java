package tk.thewoosh.plugins.wac.checks;

public class CheckResult {

	private boolean failed;
	private CheckType type;
	private String message;
	
	public CheckResult(boolean failed, CheckType type, String message) {
		this.failed = failed;
		this.type = type;
		this.message = message;
	}

	public boolean failed() {
		return failed;
	}
	
	public CheckType getType() {
		return type;
	}
	
	public String getMessage() {
		return message;
	}
	
}
