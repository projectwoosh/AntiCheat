package tk.thewoosh.plugins.wac.util;

import java.util.HashMap;

public class YMap {

	private static final HashMap<Integer, YMap> MAP;

	static {
		MAP = new HashMap<>();

		YMap normal = new YMap();
		normal.set(0, 0.42);
		normal.set(1, 0.3332);
		normal.set(2, 0.248136);
		normal.set(3, 0.164773);
		normal.set(4, 0.083078);
		normal.set(0, 0.42);
		MAP.put(0, normal);

		YMap one = new YMap();
		one.set(0, 0.52);
		one.set(1, 0.4312);
		one.set(2, 0.344176);
		one.set(3, 0.258892);
		one.set(4, 0.175315);
		one.set(5, 0.093408);
		one.set(6, 0.01314);
		MAP.put(1, one);

		YMap two = new YMap();
		two.set(0, 0.62);
		two.set(1, 0.5292);
		two.set(2, 0.440216);
		two.set(3, 0.353012);
		two.set(4, 0.267551);
		two.set(5, 0.1838);
		two.set(6, 0.101724);
		two.set(7, 0.02129);
		MAP.put(2, two);
	}

	public static YMap get(int modifier) {
		return MAP.get(modifier);
	}

	private HashMap<Integer, Double> speedMap = new HashMap<>();

	private void set(int speed, double value) {
		speedMap.put(speed, value);
	}
	
	public boolean contains(double value) {
		return speedMap.containsValue(value);
	}
	
	public boolean hasSpeed(int speed) {
		return speedMap.containsKey(speed);
	}

	public Double getSpeed(int speed) {
		return speedMap.get(speed);
	}

	public int size() {
		return speedMap.size();
	}

}
