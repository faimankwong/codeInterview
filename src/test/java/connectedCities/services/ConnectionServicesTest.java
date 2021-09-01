package connectedCities.services;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConnectionServicesTest {

	@Test
	public void ConnectionServicesTest() {
		String line = "Tampa, New york".toLowerCase();
		ConnectionServicesImpl cb = new ConnectionServicesImpl(null, "Tampaa", "Boston");
		String result[] = cb.separateLine(line);
		assertTrue("tampa".equals(result[0])
				&& "new york".equals(result[1]));
		}

}