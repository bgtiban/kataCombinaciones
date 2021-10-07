package kataCombinaciones.assistant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import kataCombinaciones.entity.Combination;
import kataCombinaciones.entity.CombinationList;
import kataCombinaciones.entity.Service;

public class HiringAssistantImpl implements IHiringAssistant {

	private List<Service> services = new ArrayList<>();

	@Override
	public List<String> searchMinimalAmount() {
		Map<Integer, CombinationList> contenedorCombinaciones = new TreeMap<>();

		for (int i = 0; i < services.size(); i++) {
			CombinationList combinaciones = new CombinationList();

			for (int x = i + 1; x < services.size(); x++) {
				Combination combinacion = new Combination();
				if (combinaciones.getCombinations().isEmpty()) {
					combinacion.getCombinations().add(services.get(i));
				} else {
					combinacion.getCombinations().addAll(combinaciones.getCombinations().get(combinaciones.getCombinations().size() - 1).getCombinations());
				}
				combinacion.getCombinations().add(services.get(x));
				combinacion.setTotalAmmount(sumAmmount(combinacion));
				combinaciones.getCombinations().add(combinacion);
			}
			
			contenedorCombinaciones.put(services.get(i).id(), combinaciones);
		}
		
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, CombinationList> mapCombinationsList : contenedorCombinaciones.entrySet()) {
			sb.append("K= " + mapCombinationsList.getKey() + "\n");
			for (Combination combination : mapCombinationsList.getValue().getCombinations()) {
				sb.append(" Combinacion: ");
				combination.getCombinations().stream().forEach(serv -> sb.append(serv.name() + ","));
				sb.append(" Media: " + combination.getAverageAmmount());
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
		return null;
	}
	
	private double sumAmmount(Combination combination) {
		return combination.getCombinations().stream().map(t -> t.amount()).toList().stream().reduce((double) 0,
				(a, b) -> a + b);
	}


	@Override
	public void add(Service service) {
		services.add(service);
	}

}
