package kataCombinaciones.entity;

import java.util.ArrayList;
import java.util.List;

public class CombinationList {

	private int id;
	
	private List<Combination> combinations = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Combination> getCombinations() {
		return combinations;
	}

	public void setCombinations(List<Combination> combinations) {
		this.combinations = combinations;
	}
}
