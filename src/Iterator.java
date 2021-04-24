public interface Iterator {

	void next();

	TravelEntity currentItem();

	void firstItem();

	boolean isDone();

}