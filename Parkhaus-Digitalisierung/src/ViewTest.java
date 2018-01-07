import static org.junit.Assert.*;
import java.time.Instant;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class ViewTest {
	Parkhaus p;
	ParkhausModell pm;
	View v1;
	View v2;
	View v3;

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
	}

}
