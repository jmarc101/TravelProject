
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


		controllerClient.reservationManager.insert(new Reservation("r1", "client", "AB101","c02ksf", 100));

		View view = new View(controllerAdministration);
		boolean run = true;
		while(run){

			String usertype = view.displayMenu(user);
			switch (usertype) {
				case "-1" -> run = false;
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
				case "create user" -> createUser(view);
			}

		}





	}


	public static void createUser(View view){
		ArrayList<String> info = view.getUserInfo();
		controllerAdministration.userManager.insert(new UserClient(info.get(0), info.get(1), info.get(2), info.get(3),
				info.get(4), info.get(5), info.get(6), info.get(7), info.get(8), info.get(9)));
	}

}