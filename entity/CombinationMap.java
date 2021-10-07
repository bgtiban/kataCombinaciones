package kataCombinaciones.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CombinationMap implements Cloneable{

	private Map<Integer, Combination> combinations = new HashMap<>();

	@Override
	public CombinationMap clone() {
		CombinationMap clon;
		try {
			clon = (CombinationMap) super.clone();
			Map<Integer, Combination> clonMap = new HashMap<>();
			for (Entry<Integer, Combination> kv : clonMap.entrySet()) {
				clonMap.put(kv.getKey(), kv.getValue().clone());
			}
			clon.setCombinations(clonMap);
		} catch (CloneNotSupportedException e) {
			clon = null;
			e.printStackTrace();
		}

		return clon;
	}

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
