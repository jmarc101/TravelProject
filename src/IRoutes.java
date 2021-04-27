import java.util.ArrayList;
import java.util.Date;

public interface IRoutes {


	/**
	 * 
	 * @param startHubID
	 * @param endHubID
	 */
	ArrayList<Route> getRoutesByHub(String vehicleType, String startHubID, String endHubID);

	/**
	 * 
	 * @param date
	 */
	ArrayList<Route> getRoutesByDate(String vehicleType, String date);

	ArrayList<Route> getAllRoutes();

}