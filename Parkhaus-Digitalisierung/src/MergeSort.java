import java.util.*;

public class MergeSort extends SortStrategy {

	public MergeSort(Comparator<Ticket> comp) {
		super(comp);
	}

	@Override
	public void sort(Ticket[] ticketList) {
		Arrays.sort(ticketList, comp);
	}

}
