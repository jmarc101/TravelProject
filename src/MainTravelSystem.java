import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainTravelSystem {

	static ControllerClient controllerClient;
	static ControllerAdministration controllerAdministration;


	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		controllerClient = new ControllerClient();
		controllerAdministration = new ControllerAdministration();
		ViewAdmin viewAdmin = new ViewAdmin(controllerAdministration);
		ViewClient viewClient = new ViewClient(controllerClient);


		FactoryAirplane airFact = FactoryAirplane.getInstance();
		Company airCanada = airFact.createCompany("AC", "AIRCAN", "555 rue des avions", 500);
		TransitHub airportMontreal = airFact.createTransitHub("YUL", "Montreal");
		TransitHub airportToronto = airFact.createTransitHub("YYZ", "Toronto");

		airCanada.getVehicle(0).toStrings();
		controllerAdministration.companyManager.insert(airCanada);
		controllerAdministration.hubManager.insert(airportMontreal);
		controllerAdministration.hubManager.insert(airportToronto);




		View view = new View(controllerAdministration);
		int usertype = view.displayMenu();
		if (usertype == 1) System.out.println("\n\nAdmin Login\nPrototype Admin: Username = admin - Password = 1234");
		else if (usertype == 3) {
			createUser(view);
			view.displayMenu();
		} else {
			System.out.println("\n\nClient Login\nPrototype Client: Username = client - Password = 1234");
		}
		while (!view.login()){}

		if (usertype == 1) viewAdmin.displayMenu();

	}


	public static void createUser(View view){
		ArrayList<String> info = view.getUserInfo();
		controllerAdministration.userManager.insert(new UserClient(info.get(0), info.get(1), info.get(2), info.get(3),
				info.get(4), info.get(5), info.get(6), info.get(7), info.get(8), info.get(9)));
	}

}