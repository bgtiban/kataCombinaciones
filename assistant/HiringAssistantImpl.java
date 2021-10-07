package kataCombinaciones.assistant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kataCombinaciones.entity.Combination;
import kataCombinaciones.entity.CombinationMap;
import kataCombinaciones.entity.Service;

public class HiringAssistantImpl implements IHiringAssistant {

	private List<Service> services = new ArrayList<>();
	private CombinationBuilder combinator = new CombinationBuilder();
	

	@Override
	public List<String> searchMinimalAmount() {
		Map<Integer, CombinationMap> contenedorCombinaciones = combinator.createCombinations(services);
		Combination lowestCombination = combinator.searchLowestCombination(contenedorCombinaciones);
		return lowestCombination.getServices().stream().map(t -> t.name()).toList();
	}

	

	@Override
	public void add(Service service) {
		services.add(service);
	}

}
