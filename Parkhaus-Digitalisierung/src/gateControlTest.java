import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class gateControlTest {
	gateControl gC;
	Parkhaus p1;
	Bezahleinrichtung b1;

	@Before
	public void setUp() throws Exception {
		p1 = new Parkhaus("Parkhaus", 2);
		b1 = new Bezahlautomat(p1, new pricePerHour(100));
		gC = new SchrankenController(new gateKonkret(), p1);
	}

	@Test
	public final void testEntrance() {
		assertTrue(gC.entrance());
		assertTrue(gC.entrance());
		assertFalse(gC.entrance());
		b1.paying(0);
		gC.exit(0);
		assertTrue(gC.entrance());
		assertFalse(gC.entrance());
	}

	@Test
	public final void testExit() {
		assertFalse(gC.exit(0));
		gC.entrance();
		gC.entrance();
		assertFalse(gC.exit(0));
		assertFalse(gC.exit(1));
		b1.paying(0);
		assertTrue(gC.exit(0));
		assertFalse(gC.exit(1));
	}

	@Test
	public final void testEmergency() {
		gC.emergency();
	}

}
