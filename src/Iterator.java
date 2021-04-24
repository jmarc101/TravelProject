public interface Iterator {

	void next();

	Iterable currentItem();

	void firstItem();

	boolean isDone();

}