import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FahrzeugtypTest {
	Fahrzeugtyp t1;
	Fahrzeugtyp t2;
	Fahrzeugtyp t3;
	Fahrzeugtyp t4;
	Fahrzeugtyp t5;
	Fahrzeugtyp t6;
	
	@Before
	public void setUp() throws Exception {
		t1 = Fahrzeugtyp.getInstance("PKW");
		t2 = Fahrzeugtyp.getInstance("Pickup");
		t3 = Fahrzeugtyp.getInstance("SUV");
		t4 = Fahrzeugtyp.getInstance("Zweirad");
		t5 = Fahrzeugtyp.getInstance("Trike");
		t6 = Fahrzeugtyp.getInstance("Quad");
	}
	@Test
	public final void test_same() {
		assertSame(t1, Fahrzeugtyp.getInstance("PKW"));
		assertSame(t2, Fahrzeugtyp.getInstance("Pickup"));
		assertSame(t3, Fahrzeugtyp.getInstance("SUV"));
		assertSame(t4, Fahrzeugtyp.getInstance("Zweirad"));
		assertSame(t5, Fahrzeugtyp.getInstance("Trike"));
		assertSame(t6, Fahrzeugtyp.getInstance("Quad"));
		assertNull(Fahrzeugtyp.getInstance("Fahrrad"));
	}
	@Test
	public final void test_Name() {
		assertEquals("PKW", t1.getName());
		assertEquals("Pickup", t2.getName());
		assertEquals("SUV", t3.getName());
		assertEquals("Zweirad", t4.getName());
		assertEquals("Trike", t5.getName());
		assertEquals("Quad", t6.getName());
	}
	@Test
	public final void test_gebuehr() {
		assertEquals(5, t1.getGebuehr());
		assertEquals(6, t2.getGebuehr());
		assertEquals(6, t3.getGebuehr());
		assertEquals(2, t4.getGebuehr());
		assertEquals(3, t5.getGebuehr());
		assertEquals(4, t6.getGebuehr());
	}
	@Test
	public final void test_parkflaeche() {
		assertEquals(12, t1.getParkflaeche());
		assertEquals(14, t2.getParkflaeche());
		assertEquals(15, t3.getParkflaeche());
		assertEquals(4, t4.getParkflaeche());
		assertEquals(8, t5.getParkflaeche());
		assertEquals(10, t6.getParkflaeche());
	}
}
