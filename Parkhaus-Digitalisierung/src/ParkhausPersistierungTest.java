import static org.junit.Assert.*;
import java.time.*;

import org.junit.Before;
import org.junit.Test;

public class ParkhausPersistierungTest {
	Parkhaus p1;
	Parkhaus p2;
	@Before
	public void setUp() throws Exception {
		p1 = new Parkhaus("p1", 3);
		p1.ticketAusstellen();
		p1.ticketAusstellen();
		p1.getTicket(0).bezahlt = true;
		p1.getTicket(0).preis = 150;
		p1.getTicket(0).ausfahrt = LocalDateTime.now();
		p2 = new Parkhaus("p2", 5);
		p2.ticketAusstellen(); p2.ticketAusstellen(); p2.ticketAusstellen();
		p2.freeSpot();
	}

	@Test
	public final void test() throws Exception {
		p1.zustandSpeichern();
		p2.zustandSpeichern("test_datei");
		Parkhaus tmp1 = new Parkhaus("NEIN", 99999);
		tmp1.zustandEinlesen("Parkhaus_p1.xml");
		Parkhaus tmp2 = new Parkhaus();
		tmp2.zustandEinlesen("test_datei");
		assertEquals(p1.toXML(), tmp1.toXML());
		assertEquals(p2.toXML(), tmp2.toXML());
		assertEquals(p1, tmp1);
		assertEquals(p2, tmp2);
	}
}