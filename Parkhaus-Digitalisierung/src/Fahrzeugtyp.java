import java.util.*;
public class Fahrzeugtyp {
	private static Map<String, Fahrzeugtyp> instances;
	private String name;
	private int parkflaeche; //in m^2
	private int gebuehr;
	
	private Fahrzeugtyp(String name, int parkflaeche, int gebuehr) {
		this.name = name;
		this.parkflaeche = parkflaeche;
		this.gebuehr = gebuehr;
	}
	
	public static Fahrzeugtyp getInstance(String key) {
		if (instances == null)
			initFahrzeugtyp();
		return instances.get(key);
	}
	
	private static void initFahrzeugtyp() {
		instances = new HashMap<>();
		instances.put("PKW", new Fahrzeugtyp("PKW", 12, 5));
		instances.put("Pickup", new Fahrzeugtyp("Pickup", 14, 6));
		instances.put("SUV", new Fahrzeugtyp("SUV", 15, 6));
		instances.put("Zweirad", new Fahrzeugtyp("Zweirad", 4, 2));
		instances.put("Trike", new Fahrzeugtyp("Trike", 8, 3));
		instances.put("Quad", new Fahrzeugtyp("Quad", 10, 4));
	}

	public String getName() { return name; }
	public int getParkflaeche() { return parkflaeche; }
	public int getGebuehr() { return gebuehr; }
}
