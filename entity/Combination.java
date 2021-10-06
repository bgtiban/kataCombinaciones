package kataCombinaciones.entity;

import java.util.ArrayList;
import java.util.List;

public class Combination {

	private int id;

	private double averageAmmount;

	private double totalAmmount;

	private List<Service> services = new ArrayList<>();

	public double getAverageAmmount() {
		if (!services.isEmpty() && 0 < totalAmmount) {
			averageAmmount = totalAmmount / (double) services.size();
		}
		return averageAmmount;
	}

	public void setTotalAmmount(double totalAmmount) {

		this.totalAmmount = totalAmmount;
	}

	public double getTotalAmmount() {
		return totalAmmount;
	}

	public int getId() {
		return id;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public void setAverageAmmount(double averageAmmount) {
		this.averageAmmount = averageAmmount;
	}

	public void setId(int id) {
		this.id = id;
	}
}
