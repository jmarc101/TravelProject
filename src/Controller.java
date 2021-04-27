import java.util.ArrayList;
import java.util.Date;

public abstract class Controller {

	private User user;
	EntityManager userManager;

	public Controller() {
		userManager =  ManagerUser.getInstance();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EntityManager getUserManager() {
		return userManager;
	}

	public void setUserManager(EntityManager userManager) {
		this.userManager = userManager;
	}




	public boolean createUser(ArrayList<String> info) {
		getUserManager().insert(new UserClient(info.get(0), info.get(1), info.get(2), info.get(3),
				info.get(4), info.get(5), info.get(6), info.get(7), info.get(8), info.get(9)));
		return true;
	}

	/**
	 * 
	 * @param id
	 */
	public boolean modifyUser(String id) {
		// TODO - implement Controller.modifyUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param id
	 */
	public boolean deleteUser(String id) {
		// TODO - implement Controller.deleteUser
		throw new UnsupportedOperationException();
	}

}