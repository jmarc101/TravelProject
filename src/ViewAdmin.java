import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ViewAdmin extends View{
    ControllerAdministration controllerAdministration;
    HashMap<String, Command> commands;

    public ViewAdmin(ControllerAdministration controller) {
        super(controller);
        controllerAdministration = controller;
        commands = new HashMap<>();

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
    public int displayMenu(){

        System.out.println("\n\nWelcome to Admin Control Panel\nPlease choose an options below\n");
        System.out.println("--Route Options--\nget route\ncreate route\nmodify route\ndelete route");
        System.out.println("--Company Options--\nget company\ncreate company\nmodify company\ndelete company");
        System.out.println("--Hub options--\nget hub\ncreate hub\nmodify hub\ndelete hub\n\n EXIT : -1");

        boolean run = true;
        while (run) {
            String result = "";



            result = listen("\n*** Enter Admin Menu Choice (CRUD) ***\n");
            System.out.println(result);
            if (commands.containsKey(result)) commands.get(result).execute();
            else if (result.equals("-1")) run = false;
            else {
                System.out.println("Invalid choice\nPlease choose again");
                try {
                    TimeUnit.SECONDS.sleep(1);

                } catch (Exception e) {

                }
            }
        }
        return 2;
    }

    public ArrayList<String> getCompanyInfo(){
        ArrayList<String> info = new ArrayList<>();

        info.add(listen("Type of company (air,naval,train) "));
        info.add(listen("Company ID (Length 2) "));
        info.add(listen("Company name "));
        info.add(listen("Address "));
        info.add(listen("Default Fare prices "));

        return info;
    }


    public ArrayList<String> getHubInfo(){
        ArrayList<String> info = new ArrayList<>();

        info.add(listen("Type of Hub (air,naval,train) "));
        info.add(listen("Hub ID (Length 3) "));
        info.add(listen("Hub town "));

        return info;
    }

    public ArrayList<String> getRouteInfo(){
        ArrayList<String> info = new ArrayList<>();
        return info;
    }

    public void addCommand(String key, Command command){
        commands.put(key,command);
    }

    public void getRoutes(){}
}