import static org.junit.Assert.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ViewTest {
	Parkhaus p;
	ParkhausModell pm;
	View v1;
	View v2;
	View v3_0;
	View v3_1;
	View v3_2;
	View v3_3;
	View v3_4;
	View v3_5;


	@Before
	public void setUp() throws Exception {
		p = new Parkhaus("Test", 10);
		p.ticketAusstellen();
		p.ticketAusstellen();
		
		Instant currentTime = Instant.now();
		
		Ticket ticket1;
		Instant leavingTime = Instant.from(LocalDate.from(currentTime).minusDays(2));
		Instant entranceTime = Instant.from(leavingTime).minusSeconds(6000);
		ticket1 = new Ticket(entranceTime, leavingTime, true, 100);
		p.addTicket(ticket1);
		
		Ticket ticket2;
		leavingTime = Instant.from(LocalDate.from(currentTime).minusDays(10));
		entranceTime = Instant.from(leavingTime).minusSeconds(6000);
		ticket2 = new Ticket(entranceTime, leavingTime, true, 1000000);
		p.addTicket(ticket2);
		
		Ticket ticket3;
		entranceTime = Instant.from(LocalDate.from(currentTime).minusDays(1));
		ticket3 = new Ticket();
		ticket3.einfahrt = entranceTime;
		p.addTicket(ticket3);
		
		Ticket ticket4;
		ticket4 = new Ticket();
		ticket4.einfahrt = entranceTime;
		p.addTicket(ticket4);
		
		pm = new ParkhausModell(10, p);
		pm.pay(5);
		pm.pay(0);
		v1 = new View1(pm);
		v2 = new View2(pm);
		v3_0 = new View3(pm, 0);
		v3_1 = new View3(pm, 1);
		v3_2 = new View3(pm, 2);
		v3_3 = new View3(pm, 3);
		v3_4 = new View3(pm, 4);
		v3_5 = new View3(pm, 5);
		pm.setViews(Arrays.asList(v1, v2, v3_0, v3_1, v3_2, v3_3, v3_4, v3_5));
	}


	@Test
	public final void test() {
		assertEquals(actual, v1.getResult());
		assertEquals(actual, v2.getResult());
		assertEquals(actual, v3_0.getResult());
		assertEquals(actual, v3_1.getResult());
		assertEquals(actual, v3_2.getResult());
		assertEquals(actual, v3_3.getResult());
		assertEquals(actual, v3_4.getResult());
		assertEquals(actual, v3_5.getResult());
	}
}
