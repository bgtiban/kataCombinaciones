package kataCombinaciones.assistant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import kataCombinaciones.entity.Service;

public class HiringAssistantImpl implements IHiringAssistant {

	private List<Service> services = new ArrayList<>();

	@Override
	public List<String> searchMinimalAmount() {
		Map<Integer, List<List<Service>>> combinations = new TreeMap<>();

		for (int i = 0; i < services.size(); i++) {
			List<List<Service>> container = new ArrayList<>();

			for (int x = i + 1; x < services.size(); x++) {
				List<Service> subcontainer = new ArrayList<>();
				if (container.isEmpty()) {
					subcontainer.add(services.get(i));
				} else {
					subcontainer.addAll(container.get(container.size() - 1));
				}
				subcontainer.add(services.get(x));
				container.add(subcontainer);
			}
			
			combinations.put(services.get(i).id(), container);
		}
		
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, List<List<Service>>> combination : combinations.entrySet()) {
			sb.append("K= " + combination.getKey() + "\n");
			for (List<Service> service : combination.getValue()) {
				sb.append(" Combinacion: ");
				service.stream().forEach(serv -> sb.append(serv.name() + ","));
//				sb.append(" Media: " + service.getAverageAmmount());
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
		return null;
	}


	@Override
	public void add(Service service) {
		services.add(service);
	}

}
