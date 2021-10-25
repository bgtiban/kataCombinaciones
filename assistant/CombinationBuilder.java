package kataCombinaciones.assistant;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import kataCombinaciones.model.Combination;
import kataCombinaciones.model.CombinationMap;
import kataCombinaciones.model.Service;

import java.util.TreeMap;

public class CombinationBuilder {
	
	private IDGenerator idGen = new IDGenerator();

	public Combination searchLowestCombination(Map<Integer, CombinationMap> contenedorCombinaciones) {
		Combination lowestCombination = new Combination();
		
		for (Entry<Integer, CombinationMap> combinationMap : contenedorCombinaciones.entrySet()) {
			for (Entry<Integer, Combination> combination : combinationMap.getValue().getCombinations().entrySet()) {
				if (lowestCombination.getId() == 0 && lowestCombination.getAverageAmmount() == 0) {
					lowestCombination = combination.getValue();
				} else {
					if (combination.getValue().getAverageAmmount() <= lowestCombination.getAverageAmmount()) {
						lowestCombination = combination.getValue();
					}
				}
			}
		}
		
		
		return lowestCombination;
	}

	public Map<Integer, CombinationMap> createCombinations(List<Service> services) {
		Map<Integer, CombinationMap> contenedorCombinaciones = new TreeMap<>();
		
		for (int i = 0; i < services.size(); i++) {
			CombinationMap combinationsMap = new CombinationMap();

			for (int x = i + 1; x < services.size(); x++) {
				Combination combination = null;
				if (combinationsMap.getCombinations().isEmpty()) {
					combination = createCombination(combinationsMap, Arrays.asList(services.get(i),  services.get(x)));
				} else {
					combination = createCombination(combinationsMap,  Arrays.asList(services.get(x)));
				}
				
				combinationsMap.getCombinations().put(combination.getId(), combination);
			}

			contenedorCombinaciones.put(services.get(i).id(), combinationsMap);
		}
		return contenedorCombinaciones;

	}

	public Combination createCombination(CombinationMap combinationsMap, Collection<Service> servs) {
		Combination combination = new Combination();
		combination.setId(idGen.newID());
		
		if (combinationsMap.getCombinations().isEmpty()) {
			combination.getServices().addAll(servs);
		} else {
			combination.getServices().addAll(combinationsMap.getCombinations().get(idGen.previousID()).getServices());
			combination.getServices().addAll(servs);
		}
		
		combination.setTotalAmmount(sumAmmount(combination));
		return combination;
	}


	
	public double sumAmmount(Combination combination) {
		return combination.getServices().stream().map(t -> t.amount()).toList().stream().reduce((double) 0,
				(a, b) -> a + b);
	}
}
