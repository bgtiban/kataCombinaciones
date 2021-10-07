package kataCombinaciones.entity;

import java.util.HashMap;
import java.util.Map;

public class CombinationMap{

	private Map<Integer, Combination> combinations = new HashMap<>();

	@Override
	public CombinationMap clone() {
		CombinationMap clon;
		try {
			clon = (CombinationMap) super.clone();
			if (clon != null) {
				clon.setCombinations(new HashMap<>(combinations));
			}
			clon = (CombinationMap) super.clone();
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
