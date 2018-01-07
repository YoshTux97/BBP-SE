import static org.junit.Assert.*;

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
		for (int i = 0; i < 10; ++i) {
			p.ticketAusstellen();
		}
		Ticket[] tick = new Ticket[10];
		for (int i = 0; i < 10; ++i) {
			tick[i] = p.getTicket(i);
		}
		
	}

	@Test
	public final void test() {
		fail("Noch nicht implementiert");
	}

}
