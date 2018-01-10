import static org.junit.Assert.*;
import java.time.*;
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
		
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate currentDate = currentTime.toLocalDate();
		
		Ticket ticket1;
		LocalDateTime leavingTime = currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1).atStartOfDay().plusSeconds(1);
		LocalDateTime entranceTime = leavingTime.minusMinutes(100);
		ticket1 = new Ticket(entranceTime, leavingTime, true, 100);
		p.addTicket(ticket1);
		
		Ticket ticket2;
		leavingTime = currentDate.minusDays(10).atStartOfDay();
		entranceTime = leavingTime.minusMinutes(100);
		ticket2 = new Ticket(entranceTime, leavingTime, true, 1000000);
		p.addTicket(ticket2);
		
		Ticket ticket3;
		entranceTime = currentDate.atStartOfDay();
		ticket3 = new Ticket();
		ticket3.einfahrt = entranceTime;
		ticket3.ausfahrt = entranceTime.plusHours(3);
		ticket3.preis = 100000;
		ticket3.bezahlt = true;
		p.addTicket(ticket3);
		
		Ticket ticket4;
		ticket4 = new Ticket();
		ticket4.einfahrt = currentTime.minusMinutes(40);
		p.addTicket(ticket4);
		
		pm = new ParkhausModell(10, p);
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
	public final void test() throws InterruptedException {
		assertEquals(100000, v1.getResult());
		assertEquals(100100, v2.getResult());
		Thread.sleep(1000);
		assertEquals(10, v3_0.getResult());
		assertEquals(10, v3_1.getResult());
		assertEquals(100, v3_2.getResult());
		assertEquals(1000000, v3_3.getResult());
		assertEquals(100000, v3_4.getResult());
		assertEquals(410, v3_5.getResult());
	}
}
