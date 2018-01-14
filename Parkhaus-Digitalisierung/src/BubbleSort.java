import java.util.*;

public class BubbleSort extends SortStrategy {

	public BubbleSort(Comparator<Ticket> comp) {
		super(comp);
	}

	@Override
	public void sort(Ticket[] ticketList) {
		int lastCPos = ticketList.length - 1; //Position des letzten Tausches
		while (lastCPos > 0) {
			int itBorder = lastCPos;
			lastCPos = 0;
			for (int i = 0; i < itBorder; ++i) {
				if (comp.compare(ticketList[i], ticketList[i+1]) > 0) {
					Ticket tmp = ticketList[i];
					ticketList[i] = ticketList[i+1];
					ticketList[i+1] = tmp;
					lastCPos = i;
				}
			}
		}
	}
}
