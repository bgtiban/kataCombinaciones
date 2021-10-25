package kataCombinaciones.test;

import org.junit.After;
import org.junit.Test;

import junit.framework.TestCase;
import kataCombinaciones.assistant.HiringAssistantImpl;
import kataCombinaciones.assistant.IHiringAssistant;


public class CombinationBuilderTest extends TestCase{
	
	private IHiringAssistant assistant;
	
	@After
	public void testAfter() {
		assistant = new HiringAssistantImpl();
		System.out.println("before");
	}
	

	@Test
	public void testCaso1() {
		System.out.println("CCB");
	}
	
	@Test
	public void testCaso2() {
		System.out.println("CCB");
	}

	
	@Test
	public void testCaso3() {
		System.out.println("CCB");
	}


}
