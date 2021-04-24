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



	/**
	 * 
	 * @param companyID
	 */
	public ArrayList<Route> getRoutesByCompany(String companyID) {
		// TODO - implement Controller.getRoutesByCompany
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param startHubID
	 * @param endHubID
	 */
	public ArrayList<Route> getRoutesByHub(String startHubID, String endHubID) {
		// TODO - implement Controller.getRoutesByHub
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param date
	 */
	public ArrayList<Route> getRoutesByDate(Date date) {
		// TODO - implement Controller.getRoutesByDate
		throw new UnsupportedOperationException();
	}

	public boolean createUser() {
		// TODO - implement Controller.createUser
		throw new UnsupportedOperationException();
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