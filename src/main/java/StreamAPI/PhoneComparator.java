package StreamAPI;

import java.util.Comparator;

public class PhoneComparator implements Comparator<Phone> {
	@Override
	public int compare(Phone p1, Phone p2) {
		if (p1.getPrice() > p2.getPrice())
			return 1;
		return -1;
	}
}
