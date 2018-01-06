import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ParkhausTest {
	Parkhaus p1;
	Parkhaus p2;

	@Before
	public void setUp() throws Exception {
		p1 = new Parkhaus("p1", 3);
		p2 = new Parkhaus("p2", 5);
	}

	@Test
	public final void testHatPlatz() {
		assertTrue(p1.hatPlatz());
		assertTrue(p2.hatPlatz());
		p1.ticketAusstellen(); p1.ticketAusstellen();
		p2.ticketAusstellen(); p2.ticketAusstellen();
		assertTrue(p1.hatPlatz());
		assertTrue(p2.hatPlatz());
		p1.ticketAusstellen();
		p2.ticketAusstellen(); p2.ticketAusstellen(); p2.ticketAusstellen();
		assertFalse(p1.hatPlatz());
		assertFalse(p2.hatPlatz());
	}

	@Test
	public final void testGetName() {
		assertEquals("p1", p1.getName());
		assertEquals("p2", p2.getName());
	}

	@Test
	public final void testGetAnzPlaetze() {
		assertEquals(3, p1.getAnzPlaetze());
		assertEquals(5, p2.getAnzPlaetze());
	}

	@Test
	public final void testTicketAusstellen() {
		assertEquals(0, p1.ticketAusstellen());
		assertEquals(0, p2.ticketAusstellen());
		assertEquals(1, p1.ticketAusstellen());
		assertEquals(1, p2.ticketAusstellen());
		assertEquals(2, p1.ticketAusstellen());
		assertEquals(2, p2.ticketAusstellen());
		assertEquals(-1, p1.ticketAusstellen());
		assertEquals(3, p2.ticketAusstellen());
		assertEquals(-1, p1.ticketAusstellen());
		assertEquals(4, p2.ticketAusstellen());
		assertFalse(p1.hatPlatz());
		assertFalse(p2.hatPlatz());
	}

	@Test
	public final void testPruefeTicket() {
		p1.ticketAusstellen();
		p2.ticketAusstellen();
		p1.ticketAusstellen();
		p2.ticketAusstellen();
		p1.ticketAusstellen();
		p2.ticketAusstellen();
		assertFalse(p1.pruefeTicket(0));
		assertFalse(p1.pruefeTicket(1));
		assertFalse(p1.pruefeTicket(2));
		assertFalse(p1.pruefeTicket(3));
		assertFalse(p2.pruefeTicket(0));
		assertFalse(p2.pruefeTicket(1));
		assertFalse(p2.pruefeTicket(2));
		assertFalse(p2.pruefeTicket(3));
		p1.getTicket(0).bezahlt = true;
		p1.getTicket(2).bezahlt = true;
		p2.getTicket(0).bezahlt = true;
		p2.getTicket(1).bezahlt = true;
		assertTrue(p1.pruefeTicket(0));
		assertFalse(p1.pruefeTicket(1));
		assertTrue(p1.pruefeTicket(2));
		assertFalse(p1.pruefeTicket(3));
		assertTrue(p2.pruefeTicket(0));
		assertTrue(p2.pruefeTicket(1));
		assertFalse(p2.pruefeTicket(2));
		assertFalse(p2.pruefeTicket(3));
	}

	@Test
	public final void testGetTicket() {
		p1.ticketAusstellen();
		p2.ticketAusstellen();
		p1.ticketAusstellen();
		p2.ticketAusstellen();
		p1.ticketAusstellen();
		p2.ticketAusstellen();
		Ticket t1_1 = p1.getTicket(0);
		Ticket t1_2 = p1.getTicket(1);
		Ticket t1_3 = p1.getTicket(2);
		Ticket t2_1 = p2.getTicket(0);
		Ticket t2_2 = p2.getTicket(1);
		Ticket t2_3 = p2.getTicket(2);
		assertNull(p1.getTicket(3));
		assertNull(p2.getTicket(3));
		assertEquals(false, t1_1.bezahlt);
		assertEquals(false, t1_2.bezahlt);
		assertEquals(false, t1_3.bezahlt);
		assertEquals(false, t2_1.bezahlt);
		assertEquals(false, t2_2.bezahlt);
		assertEquals(false, t2_3.bezahlt);
		assertNull(t1_1.ausfahrt);
		assertNull(t1_2.ausfahrt);
		assertNull(t1_3.ausfahrt);
		assertNull(t2_1.ausfahrt);
		assertNull(t2_2.ausfahrt);
		assertNull(t2_3.ausfahrt);
	}

}
