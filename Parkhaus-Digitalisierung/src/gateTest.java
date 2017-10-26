import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class gateTest {
	gate gate1;

	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void isClosed_closeGate_true() {
		gate1.close();
		assertTrue(gate1.isClosed());
	}
}
