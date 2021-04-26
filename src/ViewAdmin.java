import java.util.ArrayList;
import java.util.HashMap;

public class ViewAdmin extends View{
    ControllerAdministration controllerAdministration;
    HashMap<String, Command> commands;
    User user;

    public ViewAdmin(ControllerAdministration controller) {
        super(controller);
        controllerAdministration = controller;
        commands = new HashMap<>();

        addCommand("all routes", new CommandAllRoutes(controllerAdministration, this));
        addCommand("get route",new CommandGetRoute(controllerAdministration, this));
        addCommand("create route",new CommandCreateRoute(controllerAdministration, this));
        addCommand("modify route",new CommandModifyRoute(controllerAdministration, this));
        addCommand("delete route", new CommandDeleteRoute(controllerAdministration, this));

        addCommand("get company",new CommandGetCompany(controllerAdministration, this));
        addCommand("create company",new CommandCreateCompany(controllerAdministration, this));
        addCommand("modify company",new CommandModifyCompany(controllerAdministration, this));
        addCommand("delete company",new CommandDeleteCompany(controllerAdministration, this));

        addCommand("get hub",new CommandGetTransitHub(controllerAdministration, this));
        addCommand("create hub", new CommandCreateTransitHub(controllerAdministration, this));
        addCommand("delete hub",new CommandDeleteTransitHub(controllerAdministration, this));
        addCommand("modify hub",new CommandModifyTransitHub(controllerAdministration, this));



    }

    @Override
    public String displayMenu(User user){
    this.user = user;
        System.out.println("\n\nWelcome to Admin Control Panel\nPlease choose an options below\n");
        System.out.println("--Route Options COMMANDS--\n'get route'\n'create route'\n'modify route'\n'delete route'");
        System.out.println("--Company Options COMMANDS--\n'get company'\n'create company'\n'modify company'\n'delete company'");
        System.out.println("--Hub options COMMANDS--\n'get hub'\n'create hub'\n'modify hub'\n'delete hub'\n\nVIEW ALL ROUTES: 'all routes'\nEXIT : '-1'");

        boolean run = true;
        String result = "";
        while (run) {

            result = listen("\n*** Enter Admin Menu Choice (CRUD) ***\n");

            if (commands.containsKey(result)) commands.get(result).execute();
            else if (result.equals("-1")) run = false;
            else System.out.println("Invalid choice\nPlease choose again");
        }
        return result;
    }

    public ArrayList<String> getCompanyInfo(){
        ArrayList<String> info = new ArrayList<>();

        info.add(listen("Type of company (air,naval,train) "));
        info.add(listen("Company ID (Length 2) ").toUpperCase());
        info.add(listen("Company name ").toUpperCase());
        info.add(listen("Address "));
        info.add(listen("Default Fare prices "));

        return info;
    }


    public ArrayList<String> getHubInfo(){
        ArrayList<String> info = new ArrayList<>();

        info.add(listen("Type of Hub (air,naval,train) "));
        info.add(listen("Hub ID (Length 3) ").toUpperCase());
        info.add(listen("Hub town "));

        return info;
    }

    public ArrayList<String> getRouteInfo(){
        ArrayList<String> info = new ArrayList<>();
        info.add(listen("Type Route (air|naval|boat) "));
        ((ManagerTransitHub) controllerAdministration.hubManager).iterateHubs(info.get(0));
        info.add(listen("\nStarting Hub Id ").toUpperCase());
        info.add(listen("Ending Hub Id ").toUpperCase());
        info.add(listen("Departure Date and Hour (YYYY.MM.DD:hh.mm) " ));
        info.add(listen("Arrival Date and Hour (YYYY.MM.DD:hh.mm) " ));
        ((ManagerCompany) controllerAdministration.companyManager).iterateCompanies(info.get(0));
        info.add(listen("\nCompany Id ").toUpperCase());
        Company company = (Company) controllerAdministration.companyManager.read(info.get(5));
        if (company == null){
            System.out.println("Invalid Company");
            return null;
        }
        company.getVehiclesStrings();
        info.add(listen("\nVehicle Id ").toUpperCase());


        return info;
    }

    public void addCommand(String key, Command command){
        commands.put(key,command);
    }

}
