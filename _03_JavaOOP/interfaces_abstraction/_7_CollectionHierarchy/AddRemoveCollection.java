package interfaces_abstraction._7_CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public int add(String item) {
	this.items.add(0, item);
	return 0;
    }

    @Override
    public String remove() {
	return this.items.remove(this.items.size() - 1);
    }

}
