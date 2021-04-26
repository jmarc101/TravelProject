import java.util.ArrayList;

public class ManagerIterator implements Iterator {

	Iterable iterable;
	ArrayList<TravelEntity> list;
	int index = 0;

	public ManagerIterator(Iterable iterable) {
		this.iterable = iterable;
		this.list = iterable.getList();
	}


	public void next() {
		index++;
	}

	public TravelEntity currentItem() {
		return list.get(index);
	}

	public void firstItem() {
		index = 0;
	}

	public boolean isDone() {
		return (list.size() == 0 || index >= list.size());
	}

}