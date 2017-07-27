package tk.thewoosh.plugins.wac.checks.movement;

import tk.thewoosh.plugins.wac.checks.CheckResult;
import tk.thewoosh.plugins.wac.checks.CheckType;
import tk.thewoosh.plugins.wac.util.Distance;
import tk.thewoosh.plugins.wac.util.MovementUtil;
import tk.thewoosh.plugins.wac.util.User;

public class Glide {

	public static final CheckResult PASS = new CheckResult(false, CheckType.GLIDE, "");
	
	public static CheckResult runCheck(User user, Distance distance) {
		final double oldY = user.oldY;
//		user.wasGoingUp = distance.getFrom().getY() > distance.getTo().getY();
		user.oldY = distance.getYDiffrence();
		if (distance.getFrom().getY() > distance.getTo().getY()) {
			if (oldY >= distance.getYDiffrence() && oldY != 0 && !MovementUtil.shouldNotFlag(distance.getTo())) {
				return new CheckResult(true, CheckType.GLIDE, "tried to glide; " + oldY + " <= " + user.oldY);
			}
		} else {
			user.oldY = 0;
		}
		return PASS;
	}
	
}
