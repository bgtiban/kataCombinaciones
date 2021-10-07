package kataCombinaciones.assistant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import kataCombinaciones.entity.Combination;
import kataCombinaciones.entity.CombinationList;
import kataCombinaciones.entity.Service;

public class HiringAssistantImpl implements IHiringAssistant {

	private List<Service> services = new ArrayList<>();
	private int idCombination = 0;

	@Override
	public List<String> searchMinimalAmount() {
		Map<Integer, CombinationList> contenedorCombinaciones = new TreeMap<>();
		Combination lowestCombination = new Combination();
		for (int i = 0; i < services.size(); i++) {
			CombinationList combinaciones = new CombinationList();

			for (int x = i + 1; x < services.size(); x++) {
				Combination combination = new Combination();
				combination.setId(nextIdCombination());
				if (combinaciones.getCombinations().isEmpty()) {
					combination.getCombinations().add(services.get(i));
				} else {
					combination.getCombinations().addAll(combinaciones.getCombinations()
							.get(combinaciones.getCombinations().size() - 1).getCombinations());
				}
				combination.getCombinations().add(services.get(x));
				combination.setTotalAmmount(sumAmmount(combination));
				combinaciones.getCombinations().add(combination);
				if (lowestCombination.getId() == 0 && lowestCombination.getAverageAmmount() == 0) {
					lowestCombination = combination.clone();
				} else {
					if (combination.getAverageAmmount() <= lowestCombination.getAverageAmmount()) {
						lowestCombination = combination.clone();
					}
				}
			}

			contenedorCombinaciones.put(services.get(i).id(), combinaciones);
		}

		return lowestCombination.getCombinations().stream().map(t -> t.name()).toList();
	}

	private double sumAmmount(Combination combination) {
		return combination.getCombinations().stream().map(t -> t.amount()).toList().stream().reduce((double) 0,
				(a, b) -> a + b);
	}

	public int nextIdCombination() {
		return this.idCombination += 1;
	};

	@Override
	public void add(Service service) {
		services.add(service);
	}

}
