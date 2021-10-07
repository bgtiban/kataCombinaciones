package kataCombinaciones.entity;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	
	private int id;
	
	private double totalAmmount;
	
	private double averageAmmount;
	
	private List<Service> combinations = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalAmmount() {
		return totalAmmount;
	}

	public void setTotalAmmount(double totalAmmount) {
		this.totalAmmount = totalAmmount;
	}

	public List<Service> getCombinations() {
		return combinations;
	}

	public void setCombinations(List<Service> combinations) {
		this.combinations = combinations;
	}
	
	public double getAverageAmmount() {
		if (!combinations.isEmpty() && 0 < totalAmmount) {
			averageAmmount = totalAmmount / (double)combinations.size();
			averageAmmount = Math.round(averageAmmount*100.0)/100.0;
		}
		return averageAmmount;
	}

	public void setAverageAmmount(double averageAmmount) {
		this.averageAmmount = averageAmmount;
	}
}
