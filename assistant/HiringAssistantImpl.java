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
		Map<Integer, List<List<Service>>> contenedorCombinaciones = new TreeMap<>();

		for (int i = 0; i < services.size(); i++) {
			List<List<Service>> combinaciones = new ArrayList<>();

			for (int x = i + 1; x < services.size(); x++) {
				List<Service> combinacion = new ArrayList<>();
				if (combinaciones.isEmpty()) {
					combinacion.add(services.get(i));
				} else {
					combinacion.addAll(combinaciones.get(combinaciones.size() - 1));
				}
				combinacion.add(services.get(x));
				combinaciones.add(combinacion);
			}
			
			contenedorCombinaciones.put(services.get(i).id(), combinaciones);
		}
		
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, List<List<Service>>> combination : contenedorCombinaciones.entrySet()) {
			sb.append("K= " + combination.getKey() + "\n");
			for (List<Service> service : combination.getValue()) {
				sb.append(" Combinacion: ");
				service.stream().forEach(serv -> sb.append(serv.name() + ","));
//				sb.append(" Media: " + service.getAverageAmmount());
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
		return null;
	}


	@Override
	public void add(Service service) {
		services.add(service);
	}

}
