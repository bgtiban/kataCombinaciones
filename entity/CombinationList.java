package kataCombinaciones.entity;

import java.util.ArrayList;
import java.util.List;

public class CombinationList implements Cloneable {

	private int id;

	private List<Combination> combinations = new ArrayList<>();

	@Override
	public CombinationList clone() {
		CombinationList clon;
		try {
			clon = (CombinationList) super.clone();
			if (clon != null) {
				clon.setCombinations(new ArrayList<>(combinations));
			}
			clon = (CombinationList) super.clone();
		} catch (CloneNotSupportedException e) {
			clon = null;
			e.printStackTrace();
		}

		return clon;
	}

	@Override
	public String toString() {
		return "CombinationList [id=" + id + ", combinations=" + combinations + "]";
	}

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
