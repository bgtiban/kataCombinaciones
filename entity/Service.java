package kataCombinaciones.entity;

public record Service (int id, String name, double amount) implements Cloneable{

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return (Service) super.clone();
	}
 
	
}
