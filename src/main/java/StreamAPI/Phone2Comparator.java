package StreamAPI;

import java.util.Comparator;

public class Phone2Comparator implements Comparator<Phone2> {
	@Override
	public int compare(Phone2 a, Phone2 b) {
		return a.getName().toUpperCase().compareTo(b.getName().toUpperCase());
	}
}
