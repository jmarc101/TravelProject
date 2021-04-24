public interface EntityManager {

	/**
	 * 
	 * @param e
	 */
	void insert(TravelEntity e);

	/**
	 * 
	 * @param e
	 */
	void update(TravelEntity e);

	/**
	 * 
	 * @param id
	 */
	void delete(String id);

	/**
	 * 
	 * @param id
	 */
	TravelEntity read(String id);

}