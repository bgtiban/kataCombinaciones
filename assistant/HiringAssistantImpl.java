package kataCombinaciones.assistant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import kataCombinaciones.entity.ContainerService;
import kataCombinaciones.entity.Service;
import kataCombinaciones.entity.ServiceWrapper;

public class HiringAssistantImpl implements IHiringAssistant {

	private List<Service> listServices = new ArrayList<>();

	@Override
	public List<String> searchMinimalAmount() {
		Map<Integer, ContainerService> combinations = new TreeMap<>();

		for (int i = 0; i < listServices.size(); i++) {
			ContainerService containerServicesCombined = new ContainerService();

			for (int x = i + 1; x < listServices.size(); x++) {
				ServiceWrapper servicesCombinedsWithSucessors = new ServiceWrapper();
				if (containerServicesCombined.getServices().isEmpty()) {
					servicesCombinedsWithSucessors.getServices().add(listServices.get(i));
				} else {
					servicesCombinedsWithSucessors.getServices().addAll(containerServicesCombined.getServices()
							.get(containerServicesCombined.getServices().size() - 1).getServices());
				}
				servicesCombinedsWithSucessors.getServices().add(listServices.get(x));
				servicesCombinedsWithSucessors
						.setTotalAmmount(sumAmmount(servicesCombinedsWithSucessors.getServices()));
				servicesCombinedsWithSucessors.getAverageAmmount();
				containerServicesCombined.getServices().add(servicesCombinedsWithSucessors);

			}

			combinations.put(listServices.get(i).id(), containerServicesCombined);
		}
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, ContainerService> combination : combinations.entrySet()) {
			sb.append("K= " + combination.getKey() + "\n");
			for (ServiceWrapper service : combination.getValue().getServices()) {
				sb.append(" Combinacion: ");
				service.getServices().stream().forEach(serv -> sb.append(serv.name() + ","));
				sb.append(" Media: " + service.getAverageAmmount());
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}

		return null;
	}

	private String extractNamesServices(ContainerService v) {

		return null;
	}

	private double sumAmmount(List<Service> servicesCombinedsWithSucessors) {
		return servicesCombinedsWithSucessors.stream().map(t -> t.amount()).toList().stream().reduce((double) 0,
				(a, b) -> a + b);
	}

	@Override
	public void add(Service service) {
		listServices.add(service);
	}

}
