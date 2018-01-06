import java.util.*;
public class Parkhaus {
	private int anzPlaetze;
	private int belPlaetze;
	private String name;
	private List<Ticket> tickets;
	
	public Parkhaus() {
		this("Parkhaus", 100);
	}
	
	public Parkhaus(String name, int anzPlaetze) {
		this.name = name;
		this.anzPlaetze = anzPlaetze;
		tickets = new ArrayList<Ticket>();
		belPlaetze = 0;
	}
	
	public boolean hatPlatz() {
		return belPlaetze < anzPlaetze;
	}
	
	public String getName() { return name; }
	public int getAnzPlaetze() { return anzPlaetze; }

	public int ticketAusstellen() {
		if (hatPlatz()) {
			tickets.add(new Ticket());
			++belPlaetze;
			return tickets.size() - 1;
		} else {
			return -1;
		}
	}

	public boolean pruefeTicket(int ticketID) {
		if (ticketID >= tickets.size()) {
			System.out.println("Ungültige Ticket-ID.");
			return false;
		}
		return tickets.get(ticketID).bezahlt;
	}

	public Ticket getTicket(int id) {
		return id >= tickets.size() ? null : tickets.get(id);
	}

	public void freeSpot() {
		--belPlaetze;
	}
}