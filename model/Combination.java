package kataCombinaciones.model;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	private int id;

	private double totalAmmount;

	private double averageAmmount;

	private List<Service> services = new ArrayList<>();

	public Combination(int id) {
		super();
		this.id = id;
	}

	public Combination() {
	}

	@Override
	public String toString() {
		return "Combination [id=" + id + ", totalAmmount=" + totalAmmount + ", averageAmmount=" + averageAmmount
				+ ", combinations=" + services + "]";
	}

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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> combinations) {
		this.services = combinations;
	}

	public double getAverageAmmount() {
		if (!services.isEmpty() && 0 < totalAmmount) {
			averageAmmount = totalAmmount / (double) services.size();
			averageAmmount = Math.round(averageAmmount * 100.0) / 100.0;
		}
		return averageAmmount;
	}

	public void setAverageAmmount(double averageAmmount) {
		this.averageAmmount = averageAmmount;
	}

}
