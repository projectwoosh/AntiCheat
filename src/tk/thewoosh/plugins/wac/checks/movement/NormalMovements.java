package tk.thewoosh.plugins.wac.checks.movement;

import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.CheckType;
import tk.thewoosh.plugins.wac.checks.MoveCheck;
import tk.thewoosh.plugins.wac.util.Distance;
import tk.thewoosh.plugins.wac.util.User;

public class NormalMovements extends MoveCheck {
	
	public static final CheckResult PASS = new CheckResult(false, CheckType.NORMALMOVEMENTS, "");
	
	public NormalMovements() {
		super(CheckType.NORMALMOVEMENTS);
	}

	public CheckResult runCheck(User user, Distance distance) {
		
		
		return PASS;
	}
	
}
