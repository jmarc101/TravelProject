import java.time.LocalDate;
import java.util.ArrayList;

public class ManagerUser implements EntityManager, Iterable {

	private ArrayList<User> listUser;
	private static ManagerUser instance;


	private ManagerUser() {
		this.listUser = new ArrayList<>();

		listUser.add(new UserAdmin("admin", "1234", "Bob", "L'échalotte", "Bob@gmail.com", "555 rue du Parc",
				"555-555-5555", "1996-07-17"));

		listUser.add(new UserClient("client", "1234", "Ginette", "Bobette", "Ginette@gmail.com", "555 rue du Parc",
				"555-555-5555","1996-07-12", "123456789", "2020-06-06"));
	}

	public static ManagerUser getInstance() {
		if (instance == null) instance = new ManagerUser();
		return instance;
	}



	/**
	 * 
	 * @param e
	 */
	public void insert(TravelEntity e) {

		if (e instanceof User) listUser.add((User)e);


	}

	/**
	 * 
	 * @param e
	 */
	public void update(TravelEntity e) {
		User user = (User) e;
		int index = -1;
		for (int i = 0; i < listUser.size(); i++) {
			if (listUser.get(i).getUserName().equals(user.getUserName())) {
				index = i;
			}
		}
		if (index == -1) return;
		listUser.set(index, user);
	}

	/**
	 * 
	 * @param id
	 */
	public void delete(String id) {
		listUser.removeIf(e -> e.getUserName().equals(id));
	}

	/**
	 * 
	 * @param id
	 */
	public TravelEntity read(String id) {

		for (User user : listUser){
			if (user.getUserName().equals(id)) return user;
		}

		return null;
	}


	public Iterator createIterator() {
		// TODO - implement ManagerUser.createIterator
		throw new UnsupportedOperationException();
	}

}