import java.util.*;
public abstract class SortStrategy {
	Comparator<? super Ticket> comp;
	public SortStrategy(Comparator<? super Ticket> comp) {
		this.comp = comp;
	}
	public abstract void sort(Ticket[] ticketList);
}
