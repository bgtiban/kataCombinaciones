package kataCombinaciones.assistant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

import kataCombinaciones.entity.CombinationList;
import kataCombinaciones.entity.Service;
import kataCombinaciones.entity.Combination;

public class HiringAssistantImpl implements IHiringAssistant {

	private List<Service> listServices = new ArrayList<>();
	private int actualId = 0;

	@Override
	public List<String> searchMinimalAmount() {
		Map<Integer, Combination> combinations = new HashMap<>();
		List<Combination> lowerCombinatios = new ArrayList<>();

		for (int i = 0; i < listServices.size(); i++) {

			for (int x = i + 1; x < listServices.size(); x++) {
				Combination combination = new Combination();
				if (combinations.isEmpty()) {
					combination.getServices().add(listServices.get(i));
				} else {
					combination.getServices().addAll(combinations.get(actualId).getServices());
				}
				combination.getServices().add(listServices.get(x));
				combination.setTotalAmmount(sumAmmount(combination.getServices()));
				combination.getAverageAmmount();
				combinations.put(nextKey(), combination);

			}
		}
		StringBuilder sb = new StringBuilder();
		int Idlowest = 0;
		for (Entry<Integer, Combination> combination : combinations.entrySet()) {
			sb.append(" Combinacion " + combination.getKey() + ": ");
			combination.getValue().getServices().stream().forEach(serv -> sb.append(serv.name() + ","));
			sb.append(" Media: " + combination.getValue().getAverageAmmount());
			sb.append("\n");
			// lowest =

		}

		System.out.println(sb.toString());

		return null;
	}

	private String extractNamesServices(CombinationList v) {

		return null;
	}

	private double sumAmmount(List<Service> servicesCombinedsWithSucessors) {
		return servicesCombinedsWithSucessors.stream().map(t -> t.amount()).toList().stream().reduce((double) 0,
				(a, b) -> a + b);
	}

	private int nextKey() {
		return actualId += 1;
	}

	@Override
	public void add(Service service) {
		listServices.add(service);
	}

}
