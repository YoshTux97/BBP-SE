import java.util.*;

public class QuickSort extends SortStrategy {

	public QuickSort(Comparator<Ticket> comp) {
		super(comp);
	}

	@Override
	public void sort(Ticket[] ticketList) {
		quicksort(ticketList, 0, ticketList.length - 1);
	}

	private void quicksort(Ticket[] a, int l, int r) {
		if (l < r) {
			int q = partition(a, l, r);
			quicksort(a, l, q);
			quicksort(a, q+1, r);
		}
	}

	private int partition(Ticket[] a, int l, int r) {
		Ticket x = a[(l+r)/2];
		int i = l-1;
		int j = r+1;
		while(i < j) {
			do { --j; } while (comp.compare(a[j], x) > 0);
			do { ++i; } while (comp.compare(a[i], x) < 0);
			if (i < j) {
				Ticket tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		return j;
	}
}
