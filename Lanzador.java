package kataCombinaciones;

import kataCombinaciones.assistant.HiringAssistantImpl;
import kataCombinaciones.entity.Service;

public class Lanzador {

	public static void main(String[] args) {
		
		HiringAssistantImpl a = new HiringAssistantImpl();

		a.add(new Service(1, "S2", 10.0));
		a.add(new Service(2, "S2", 5.0));
		a.add(new Service(3, "S2", 3.0));

		// Salida esparada: S2, S3
		System.out.println(a.searchMinimalAmount());
		
		HiringAssistantImpl a1 = new HiringAssistantImpl();

		a1.add(new Service(1, "S1", 4.0));
		a1.add(new Service(2, "S2", 2.0));
		a1.add(new Service(3, "S3", 2.0));
		a1.add(new Service(4, "S4", 5.0));
		a1.add(new Service(5, "S5", 1.0));
		a1.add(new Service(6, "S6", 5.0));
		a1.add(new Service(7, "S7", 8.0));

		// Salida esparada: S2, S3
		System.out.println(a1.searchMinimalAmount());

		HiringAssistantImpl a2 = new HiringAssistantImpl();

		a2.add(new Service(1, "S1", 5.0));
		a2.add(new Service(2, "S2", 6.0));
		a2.add(new Service(3, "S3", 3.0));
		a2.add(new Service(4, "S4", 4.0));
		a2.add(new Service(5, "S5", 9.0));

		// Salida esparada: S3,S4
		System.out.println(a2.searchMinimalAmount());

		HiringAssistantImpl a3 = new HiringAssistantImpl();

		a3.add(new Service(1, "S1", 5.0));
		a3.add(new Service(2, "S2", 6.0));
		a3.add(new Service(3, "S3", 2.0));
		a3.add(new Service(4, "S4", 3.0));
		a3.add(new Service(5, "S5", 2.0));

		// Salida esparada: S3,S4,S5
		System.out.println(a3.searchMinimalAmount());

	}

	private static void extracted() {
	
	}

}
