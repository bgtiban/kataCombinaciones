package kataCombinaciones.assistant;

import java.util.List;

import kataCombinaciones.entity.Service;

public interface IHiringAssistant {

	public List<String> searchMinimalAmount();
	
	public void add(Service service);

}
