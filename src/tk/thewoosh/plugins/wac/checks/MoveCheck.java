package tk.thewoosh.plugins.wac.checks;

import tk.thewoosh.plugins.wac.util.Distance;
import tk.thewoosh.plugins.wac.util.User;

public abstract class MoveCheck extends Check {

	public MoveCheck(CheckType type) {
		super(type);
	}
	
	public abstract CheckResult runCheck(User user, Distance distance);
	
	
}
