import java.util.ArrayList;

public class ViewClient extends View{
    ControllerClient controllerClient;

    public ViewClient(ControllerClient controller) {
        super(controller);
        controllerClient = controller;

    }


    public String displayMenu(){
        System.out.println("\n\nWelcome to Client Control Panel\nPlease choose an options below\n");
        System.out.println("--Client Options COMMANDS--\n'view routes'\n'pay seat'\n'reservations'");
        System.out.println("\nEXIT : '-1'");

        boolean run = true;
        String result = "";
        while (run) {

            result = listen("\n*** Enter Client Menu Choice ('view routes'|'pay seat'|'reservations') ***\n");

            switch (result) {
                case "view routes" -> clientRouteView();
                case "pay seat" -> clientPaySeat();
                case "reservation" -> clientReservation();
                case "-1" -> {
                    run = false;
                    System.out.println("Going Back");
                }
                default -> System.out.println("Invalid choice\nPlease choose again");
            }
        }
        return result;
    }


    public void clientRouteView(){
        ArrayList<Route> routes = new ArrayList<>();
        String type = chooseVehicle();
        String[] section = chooseSection();
        if (type.equals("-1") || section[1].equals("-1") ) return;
        String sectionName = section[0];
        char sectionID = section[1].charAt(0);

        System.out.println("\nChoose options\n\n'by date'\n'by hub'\n'all'");
        String result = listen("");
        String date;
        String hubDepart;
        String hubArrival;
        switch (result) {
            case "by date" -> {
                date = listen("Enter Departure Date (YYYY.MM.DD) ");

                routes = getControllerClient().getRoutesByDate(type,sectionID,date);

                for (Route route : routes){
                    getControllerClient().visit(route, sectionID);
                }

                reserveSeat(routes, sectionID);

            }
            case "by hub" -> {
                System.out.println("** Hub choices** \nAirports (YUL|YYZ|JFK)\nTrain Stations (MTT|TTT|NYT)\nBoat Ports (MTP|TTP|NYP)\n");
                hubDepart = listen("Enter Departure Hub ");
                hubArrival = listen("Enter Arrival Hub ");
                routes = getControllerClient().getRoutesByHub(type,sectionID, hubDepart, hubArrival);

                for (Route route : routes){
                    getControllerClient().visit(route, sectionID);
                }
                reserveSeat(routes, sectionID);
            }
            case "all" -> {

                switch (type) {
                    case "airplane" -> {
                        System.out.println("*** Vehicle: " + type + " | Section: " + sectionName);

                        for (Route route : getControllerClient().getAllRoutes()) {
                            if (route.getVehicle() instanceof VehicleAirplane) {
                                routes.add(route);
                                getControllerClient().visit(route, sectionID);
                            }
                        }
                        reserveSeat(routes, sectionID);

                    }

                    case "boat" -> {
                        System.out.println("*** Vehicle: " + type + " | Section: " + sectionName);
                        for (Route route : getControllerClient().getAllRoutes()) {
                            if (route.getVehicle() instanceof VehicleBoat) {
                                routes.add(route);
                                getControllerClient().visit(route, sectionID);
                            }
                        }
                        reserveSeat(routes, sectionID);

                    }
                    case "train" -> {
                        System.out.println("*** Vehicle: " + type + " | Section: " + sectionName + " ***");
                        for (Route route : getControllerClient().getAllRoutes()) {
                            if (route.getVehicle() instanceof VehicleTrain) {
                                routes.add(route);
                                getControllerClient().visit(route, sectionID);
                            }
                        }
                        reserveSeat(routes, sectionID);

                    }
                }
            }
        }

    }

    public void clientReservation(){
        System.out.println("Reservations");
    }

    public void clientPaySeat(){
        System.out.println("Pay seat!");
    }

    public ControllerClient getControllerClient() {
        return controllerClient;
    }

    public String chooseVehicle(){
        System.out.println("\n *** View Routes ***\n** Choose Vehicle Type **\n'airplane'\n'train'\n'boat'");
        String type =listen("\n");
        if (type.equals("airplane") || type.equals("train") || type.equals("boat")) return type;
        return "-1";
    }

    public String[] chooseSection(){
        System.out.println("\n** Choose Section **\n'premium'\n'economy'\n'first'");
        String[] type = new String[2];
        type[0] = listen("\n");
        type[1] = "-1";
        switch (type[0]){
            case "premium" -> {type[1] = "P";}
            case "economy" -> {type[1] = "E";}
            case "first" -> {type[1] = "F";}
        }
        return type;
    }


    public void reserveSeat(ArrayList<Route> routes, char section){
        System.out.println("\n**Options**\n'reserve seat'\n'go back'\n");
        String result = listen("");
        switch (result){
            case "reserve seat" ->{
                StringBuilder ids = new StringBuilder("|");
                for (Route route : routes){
                    ids.append(route.getRouteID()).append("|");
                }
                System.out.println("Please choose one route Id --> " + ids);
                String choice = listen("");
                Route route = (Route)getControllerClient().getRouteManager().read(choice);
                if (route == null) {
                    System.out.println("Invalide choice -- going back");
                    return;
                }
                System.out.println("\n\n");
                getControllerClient().visit(route, section);
                viewSeats(route, section);
                String columnNumber = listen("Enter Column number ");
                String seatNum = listen("Enter Seat number ");

                String seatID = "C"+columnNumber+"N"+seatNum;
                System.out.println("Seat Id -> " + seatID);

            }
        }

    }


    public void viewSeats(Route route, char section){
        ArrayList<Seat> seats = route.getSeats();

        String[] cols = {"Column 1|Seat|", "Column 2|Seat|", "Column 3|Seat|", "Column 4|Seat|",
                "Column 5|Seat|", "Column 6|Seat|", "Column 7|Seat|", "Column 8|Seat|", "Column 9|Seat|", "Column 10|Seat|"};

        for (Seat seat: seats){
            for (int i = 1; i <= cols.length; i++) {
                if (("" + seat.getSeatID().charAt(1)).equals(""+i)  && seat.isAvailable() && seat.getSectionID() == section){
                    cols[i - 1] += "N" + seat.getNumber() + "|";
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            System.out.println(cols[i]);
        }
    }

}
