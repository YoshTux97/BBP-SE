import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class payTest {
	pay pay1;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void paying_liquidCustomer_true() {
		assertTrue(pay1.paying(1));
	}
	
	public void paying_brokeCustomer_false() {
		assertFalse(pay1.paying(2));
	}

}
