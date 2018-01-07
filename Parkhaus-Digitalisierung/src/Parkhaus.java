import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import com.thoughtworks.xstream.XStream;
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

	int ticketAusstellen() {
		if (hatPlatz()) {
			tickets.add(new Ticket());
			++belPlaetze;
			return tickets.size() - 1;
		} else {
			return -1;
		}
	}

	public boolean pruefeTicket(int ticketID) {
		if (ticketID >= tickets.size() || ticketID < 0) {
			System.out.println("Ungültige Ticket-ID.");
			return false;
		}
		return tickets.get(ticketID).bezahlt;
	}

	public Ticket getTicket(int id) {
		return id >= tickets.size() || id < 0 ? null : tickets.get(id);
	}
	
	Stream<Ticket> getTicketsStream() {
		return tickets.stream();
	}

	void freeSpot() {
		if (belPlaetze > 0)
			--belPlaetze;
		else
			throw new IllegalStateException();
	}
	
	public boolean equals(Object o2) {
		if (o2 == null)
			return false;
		if (o2.getClass().equals(getClass())) {
			Parkhaus ph2 = (Parkhaus) o2;
			return anzPlaetze == ph2.anzPlaetze && belPlaetze == ph2.belPlaetze && name.equals(ph2.name)
					&& tickets.equals(ph2.tickets);
			
		} else {
			return false;
		}
	
	}
	
	public void zustandSpeichern() throws IOException {
		zustandSpeichern("Parkhaus_"+name+".xml");
	}
	
	public void zustandSpeichern(String fileName) throws IOException {
		XStream xstream = new XStream();
		xstream.toXML(this, new FileWriter(fileName));
	}
	
	public String toXML() {
		XStream xstream = new XStream();
		return xstream.toXML(this);
	}
	
	public void zustandEinlesen() throws IOException {
		zustandEinlesen("Parkhaus_"+name+".xml");
	}
	
	public void zustandEinlesen(String fileName) throws IOException {
		XStream xstream = new XStream();
		XStream.setupDefaultSecurity(xstream);
		xstream.allowTypes(new Class[] {Parkhaus.class, Ticket.class});
		Parkhaus tmpP = (Parkhaus) xstream.fromXML(new File(fileName));
		anzPlaetze = tmpP.anzPlaetze;
		belPlaetze = tmpP.belPlaetze;
		name = tmpP.name;
		tickets = tmpP.tickets;
	}
}