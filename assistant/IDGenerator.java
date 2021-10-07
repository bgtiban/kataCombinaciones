package kataCombinaciones.assistant;

public class IDGenerator {

	private int id = 0;

	public int previousID() {
		return id - 1;
	}

	public int newID() {
		return this.id += 1;
	}
}
