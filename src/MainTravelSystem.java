
import java.util.ArrayList;

public class MainTravelSystem {

	static ControllerClient controllerClient;
	static ControllerAdministration controllerAdministration;
	static User user;




	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		controllerClient = new ControllerClient();
		controllerAdministration = new ControllerAdministration();
		ViewAdmin viewAdmin = new ViewAdmin(controllerAdministration);
		ViewClient viewClient = new ViewClient(controllerClient);


		controllerClient.reservationManager.insert(new Reservation("r88888888", "client", "AB101","c02ksf", 100));

		View view = new View(controllerAdministration);
		boolean run = true;
		while(run){

			String usertype = view.displayMenu(user);
			switch (usertype) {
				case "exit" -> {run = false;}
				case "admin" -> {
					System.out.println("*** Admin Login ***\nDummy admin: Username = admin - Password = 1234");
					do{	user = view.login();} while (user == null);
					viewAdmin.displayMenu(user);
				}
				case "client" -> {
					System.out.println("*** Client Login ***\nDummy client: Username = client - Password = 1234");
					do{	user = view.login();} while (user == null);
					viewClient.displayMenu(user);
				}
				case "create user" -> {
					ArrayList<String> info = view.getUserInfo();
					controllerClient.createUser(info);
				}
			}
		}
	}
}