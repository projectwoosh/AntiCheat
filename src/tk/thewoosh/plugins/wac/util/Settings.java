package tk.thewoosh.plugins.wac.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Settings {

	public static final double COMBAT_MAX_REACH_SURVIVAL = 3.7; // You can play around and improve this...
	public static final double COMBAT_MAX_REACH_CREATIVE = 5.25; // You can play around and improve this...
	public static final int COMBAT_MAX_CPS = 15; // You can change this, or notify not to butterfly / jitter click.
	public static final int CLEAN_UP_DELAY = 200;
	public static final int MAX_ENTITIES = 6;
	
	public static final int ROUNDING_PLACES = 6;

	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
	public static double round(double value) {
		return round(value, ROUNDING_PLACES);
	}
	
}
