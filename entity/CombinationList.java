package kataCombinaciones.entity;

import java.util.HashMap;
import java.util.Map;

public class CombinationList {

	private int id;

	private Map<Integer, Combination> combinations = new HashMap<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<Integer, Combination> getCombinations() {
		return combinations;
	}

	public void setCombinations(Map<Integer, Combination> combinations) {
		this.combinations = combinations;
	}

}
