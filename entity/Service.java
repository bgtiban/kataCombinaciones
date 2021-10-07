package kataCombinaciones.entity;

public record Service (int id, String name, double amount) implements Cloneable{

	@Override
	protected Service clone() {
		Service clon;
		try {
			clon = (Service) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			clon = null;
		}
		
		return clon;
	}

	
	
	
}
