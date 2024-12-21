package interfaces_abstraction._6_MilitaryElite;

import java.util.Comparator;

public class CompareById<Private> implements Comparator<Private> {

    @Override
    public int compare(Private o1, Private o2) {
	int x = ((PrivateImpl) o2).getId();
	int y = ((PrivateImpl) o1).getId();

	return Integer.compare(x, y);
    }

}
