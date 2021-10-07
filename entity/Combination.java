package kataCombinaciones.entity;

import java.util.ArrayList;
import java.util.List;

public class Combination implements Cloneable {

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
	public Combination clone() {
		Combination clon;
		try {
			clon = (Combination) super.clone();
			List<Service> clonServs = new ArrayList<>();
			for(Service service : services) {
				clonServs.add(service.clone());
			}
			clon.setServices(clonServs);
		} catch (CloneNotSupportedException e) {
			clon = null;
			e.printStackTrace();
		}

		return clon;
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
