import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BezahleinrichtungTest {
	Bezahleinrichtung b1;
	Parkhaus p1;

	@Before
	public void setUp() throws Exception {
		p1 = new Parkhaus("x", 3);
		b1 = new Bezahlautomat(p1, new pricePerHour(100));
	}

	@Test
	public final void testPaying_nonExistent() {
		assertFalse(b1.paying(0));
	}

	@Test
	public final void testPaying_alreadyPayes() {
		p1.ticketAusstellen();
		p1.getTicket(0).bezahlt = true;
		assertFalse(b1.paying(0));
	}
	@Test
	public final void testPaying() {
		p1.ticketAusstellen();
		p1.ticketAusstellen();
		assertTrue(b1.paying(0));
		assertFalse(b1.paying(0));
		assertTrue(b1.paying(1));
		assertTrue(p1.getTicket(0).bezahlt);
		assertNotNull(p1.getTicket(0).ausfahrt);
		assertTrue(p1.getTicket(1).bezahlt);
		assertNotNull(p1.getTicket(1).ausfahrt);
	}
}
