
public class Fahrzeugtyp {
	public static Fahrzeugtyp PKW = new Fahrzeugtyp("PKW", 12, 5);
	public static Fahrzeugtyp Pickup = new Fahrzeugtyp("Pickup", 14, 6);
	public static Fahrzeugtyp SUV = new Fahrzeugtyp("SUV", 15, 6);
	public static Fahrzeugtyp Zweirad = new Fahrzeugtyp("Zweirad", 4, 2);
	public static Fahrzeugtyp Trike = new Fahrzeugtyp("Trike", 8, 3);
	public static Fahrzeugtyp Quad = new Fahrzeugtyp("Quad", 10, 4);
	
	private String name;
	private int parkflaeche; //in m^2
	private int gebuehr;
	
	private Fahrzeugtyp(String name, int parkflaeche, int gebuehr) {
		this.name = name;
		this.parkflaeche = parkflaeche;
		this.gebuehr = gebuehr;
	}

	public String getName() { return name; }
	public int getParkflaeche() { return parkflaeche; }
	public int getGebuehr() { return gebuehr; }
}
