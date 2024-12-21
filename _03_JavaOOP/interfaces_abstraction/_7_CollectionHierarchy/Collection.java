package interfaces_abstraction._7_CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    protected int maxSize;
    protected List<String> items;

    Collection() {
	this.maxSize = 100;
	this.items = new ArrayList<>(maxSize);
    }

}
