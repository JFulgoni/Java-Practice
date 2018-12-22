package twenty_eighteen;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class MavenBasicTest {
	
	@Test
	public void testMavenIfItWorked() {
		String myString = "Hallo any else Danmark my friends?";
		
		assertTrue(StringUtils.contains(myString, "Danmark"));
	}

}
