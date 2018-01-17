import static org.junit.Assert.*;
import java.time.*;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ViewTest {
	Parkhaus p;
	ParkhausModell pm;
	View vT;
	View vW;
	View vKP_0;
	View vKP_1;
	View vKP_2;
	View vKP_3;
	View vKP_4;
	View vKP_5;


	@Before
	public void setUp() throws Exception {
		p = new Parkhaus("Test", 10);
		p.ticketAusstellen();
		p.ticketAusstellen();
		
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate currentDate = currentTime.toLocalDate();
		
		Ticket ticket1;
		LocalDateTime leavingTime = currentDate.minusDays(currentDate.getDayOfWeek().getValue() - 1).atStartOfDay();
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
		vT = new ViewTageseinnahmen(pm);
		vW = new ViewWocheneinnahmen(pm);
		vKP_0 = new ViewTicketPreis(pm, 0);
		vKP_1 = new ViewTicketPreis(pm, 1);
		vKP_2 = new ViewTicketPreis(pm, 2);
		vKP_3 = new ViewTicketPreis(pm, 3);
		vKP_4 = new ViewTicketPreis(pm, 4);
		vKP_5 = new ViewTicketPreis(pm, 5);
		pm.setViews(Arrays.asList(vT, vW, vKP_0, vKP_1, vKP_2, vKP_3, vKP_4, vKP_5));
	}


	@Test
	public final void test() throws InterruptedException {
		assertEquals(100000, vT.getResult());
		assertEquals(100100, vW.getResult());
		Thread.sleep(1000);
		assertEquals(10, vKP_0.getResult());
		assertEquals(10, vKP_1.getResult());
		assertEquals(100, vKP_2.getResult());
		assertEquals(1000000, vKP_3.getResult());
		assertEquals(100000, vKP_4.getResult());
		assertEquals(410, vKP_5.getResult());
	}
}
