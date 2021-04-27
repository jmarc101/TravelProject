import java.util.ArrayList;

public class ViewClient extends View{
    ControllerClient controllerClient;
    User user;

    public ViewClient(ControllerClient controller) {
        super(controller);
        controllerClient = controller;

    }


    public String displayMenu(User user){
        this.user = user;
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
                case "reservations" -> clientReservation();
                case "-1" -> {
                    run = false;
                    System.out.println("Going Back");
                }
                default -> System.out.println("Invalid choice\nPlease choose again");
            }
        }
        return result;
    }


    public void clientPaySeat(){
        clientReservation();
        System.out.println("\nPlease Enter ResID for reservation to pay\n");
        String res = listen("");
        Reservation reservation2 = (Reservation) getControllerClient().getReservationManager().read(res);
        if (reservation2 == null) {
            System.out.println("Invalid Reservation");
        }
        ArrayList<String> info = getCC();
        CreditCard creditCard = new CreditCard(info.get(0), info.get(1), info.get(2), info.get(3));
        boolean payment = getControllerClient().makePayment(res, creditCard);
        if (payment) {
            System.out.println("*** Payment Confirmed ***");
            Reservation reservation = (Reservation) getControllerClient().reservationManager.read(res);
            reservation.getPayment().toStrings();
        }
        else {
            System.out.println("Payment Failed");
        }

    }


    public void clientRouteView(){
        ArrayList<Route> routes = new ArrayList<>();
        String type = chooseVehicle();
        String[] section = chooseSection(type);
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
        System.out.println("*** Your Reservations ***");
        Iterator iterator = getControllerClient().getReservationIterator();
        ArrayList<Reservation> reservations = new ArrayList<>();
        while (!iterator.isDone()){
            TravelEntity item = iterator.currentItem();
            Reservation reservation = (Reservation) item;
            if (reservation.getClientID().equals(user.getUserName())) reservations.add(reservation);
            iterator.next();
        }
        for (Reservation reservation : reservations){
            System.out.println(reservation.toString());
        }
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

    public String[] chooseSection(String vehicletype){
        String[] type = new String[2];
        type[1] = "-1";
        if (vehicletype.equals("boat")){
            System.out.println("\n** Choose Section **\n'family cabin'\n'premium family'" +
                    "\n'interior cabin'\n'ocean view'\n'suite cabin'");
            type[0] = listen("\n");
            switch (type[0]){
                case "family cabin" -> type[1] = "F";
                case "premium family" -> type[1] = "D";
                case "interior cabin" -> type[1] = "I";
                case "ocean view" -> type[1] = "O";
                case "suite cabin" -> type[1] = "S";
            }
            return type;

        }

        System.out.println("\n** Choose Section **\n'premium'\n'economy'\n'business'\n'first'");

        type[0] = listen("\n");
        type[1] = "-1";
        switch (type[0]){
            case "premium" -> type[1] = "P";
            case "economy" -> type[1] = "E";
            case "first" -> type[1] = "F";
            case "business" -> type[1] = "D";
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
                    System.out.println("Invalid choice -- going back");
                    return;
                }

                String seatID = getSeatId(route, section);
                boolean reserved = getControllerClient().reserveSeat(route.getRouteID() , user.getUserName(), seatID);
                if (reserved)System.out.println("Seat Reserved, Please pay within 24 hours");
                else System.out.println("Error reserving seat, please try again");

            }
        }
    }

    public String getSeatId(Route route, char section){

        getControllerClient().visit(route, section);
        viewSeats(route, section);
        String columnNumber = listen("\n\nEnter Column number ");
        String seatNum = listen("Enter Seat number ");

        return "" + section + "C" + columnNumber + "|N" + seatNum;
    }


    public void viewSeats(Route route, char section){
        ArrayList<Seat> seats = route.getSeats();
        String[] cols = {"Column 1|Seat|", "Column 2|Seat|", "Column 3|Seat|", "Column 4|Seat|",
                "Column 5|Seat|", "Column 6|Seat|", "Column 7|Seat|", "Column 8|Seat|", "Column 9|Seat|", "Column 10|Seat|"};

        if (route.getVehicle() instanceof VehicleBoat){
            for (int i = 0; i < cols.length; i++) {
                cols[i] = "Cabin "+ (i+1) + "| ";
            }
        }





        for (Seat seat: seats){
            for (int i = 1; i <= cols.length; i++) {
                if (("" + seat.getSeatID().charAt(2)).equals(""+i)  && seat.isAvailable() && seat.getSectionID() == section){
                    cols[i - 1] += "N" + seat.getNumber() + "|";
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(cols[i]);
        }
    }

    public ArrayList<String> getCC(){
        System.out.println("*** Credit Card Info Required ***");
        ArrayList<String> list = new ArrayList<>();
        list.add(listen("Name on Card " ));
        list.add(listen("Card Number " ));
        list.add(listen("Expiration Date " ));
        list.add(listen("CVV " ));
        return list;
    }

}
