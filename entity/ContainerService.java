package kataCombinaciones.entity;

import java.util.ArrayList;
import java.util.List;

public class ContainerService {

	private int id;

	private List<ServiceWrapper> services = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ServiceWrapper> getServices() {
		return services;
	}

	public void setServices(List<ServiceWrapper> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "ContainerService [id=" + id + ", services=" + services + "]";
	}

}
