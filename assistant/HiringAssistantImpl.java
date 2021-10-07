package kataCombinaciones.assistant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import kataCombinaciones.entity.Combination;
import kataCombinaciones.entity.CombinationMap;
import kataCombinaciones.entity.Service;

public class HiringAssistantImpl implements IHiringAssistant {

	private List<Service> services = new ArrayList<>();
	private int idActualCombination = 0;

	@Override
	public List<String> searchMinimalAmount() {
		Map<Integer, CombinationMap> contenedorCombinaciones = new TreeMap<>();
		Combination lowestCombination = new Combination();
		
		for (int i = 0; i < services.size(); i++) {
			CombinationMap combinationsMap = new CombinationMap();

			for (int x = i + 1; x < services.size(); x++) {
				Combination combination = new Combination();
				combination.setId(nextIdCombination());
				if (combinationsMap.getCombinations().isEmpty()) {
					combination.getServices().add(services.get(i));
				} else {
					combination.getServices()
							.addAll(combinationsMap.getCombinations().get(previusCombination()).getServices());
				}
				combination.getServices().add(services.get(x));
				combination.setTotalAmmount(sumAmmount(combination));
				combinationsMap.getCombinations().put(combination.getId(), combination);
				if (lowestCombination.getId() == 0 && lowestCombination.getAverageAmmount() == 0) {
					lowestCombination = combination.clone();
				} else {
					if (combination.getAverageAmmount() <= lowestCombination.getAverageAmmount()) {
						lowestCombination = combination.clone();
					}
				}
			}

			contenedorCombinaciones.put(services.get(i).id(), combinationsMap);
		}

		return lowestCombination.getServices().stream().map(t -> t.name()).toList();
	}

	private Object previusCombination() {
		return idActualCombination - 1;
	}

	private double sumAmmount(Combination combination) {
		return combination.getServices().stream().map(t -> t.amount()).toList().stream().reduce((double) 0,
				(a, b) -> a + b);
	}

	public int nextIdCombination() {
		return this.idActualCombination += 1;
	};

	@Override
	public void add(Service service) {
		services.add(service);
	}

}
