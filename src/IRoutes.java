import java.util.ArrayList;
import java.util.Date;

public interface IRoutes {

	/**
	 * 
	 * @param companyID
	 */
	ArrayList<Route> getRoutesByCompany(String companyID);

	/**
	 * 
	 * @param startHubID
	 * @param endHubID
	 */
	ArrayList<Route> getRoutesByHub(String startHubID, String endHubID);

	/**
	 * 
	 * @param date
	 */
	ArrayList<Route> getRoutesByDate(Date date);

}