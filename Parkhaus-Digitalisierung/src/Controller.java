import java.util.*;

public class Controller {
	private ParkhausModell modell;
	private List<View> views;
	
	public Controller(int...TicketIDs) {
		views = new ArrayList<View>();
		modell = new ParkhausModell("Controlled Parkhaus", 10, 5);
		modell.setViews(views);
		views.add(new View1(modell));
		views.add(new View2(modell));
	}
	public void addCustomerView(int TicketID) {
		if (modell.getTicket(TicketID) != null)
			views.add(new View3(modell, TicketID));
		else
			System.out.println("Hinzufügen fehlgeschlagen, ungültige TicketID.");
	}
	public long[] getViewResults() {
		long[] tmp = new long[views.size()];
		for (int i = 0; i < tmp.length; ++i) {
			tmp[i] = views.get(i).getResult();
		}
		return tmp;
	}
}
