package kataCombinaciones.entity;

import java.util.HashMap;
import java.util.Map;

public class CombinationMap {

	private Map<Integer, Combination> combinations = new HashMap<>();


	@Override
	public String toString() {
		return "CombinationList [combinations=" + combinations + "]";
	}

	public Map<Integer, Combination> getCombinations() {
		return combinations;
	}

	public void setCombinations(Map<Integer, Combination> combinations) {
		this.combinations = combinations;
	}

}
