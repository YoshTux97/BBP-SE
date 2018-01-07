import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ViewManagerTest {

	Parkhaus p;
	ParkhausModell pm;
	ViewManager v1;
	ViewManager v2;
	@Before
	public void setUp() throws Exception {
		p = new Parkhaus("test", 10);
		for (int i = 0; i < 10; ++i) {
			p.ticketAusstellen();
		}
	}

	@Test
	public final void test() {
		fail("Noch nicht implementiert");
	}

}
