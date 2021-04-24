import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class View implements IObserver {

    Scanner scan = new Scanner(System.in);
    Controller controller;
    User user;


    public View(Controller controller) {
        this.controller = controller;

    }

    public boolean login(){
        String username = listen("Please Enter Username ");
        String password = listen("Please Enter Password ");

        User user = (User) controller.userManager.read(username);
        if (user == null) {
            System.out.println("\nWrong Username");
            return false;
        }
        if (!user.getPassword().equals(password)) {
            System.out.println("Wrong Password");
            return false;
        }
        System.out.println("Login Successful");
        return true;
    }

    public int displayMenu() {
        int result = 0;
        System.out.println("\n\nWelcome to travel reservation App\nPlease choose which type of user\n\n" +
                "Admin: 1\n" +
                "Client: 2\nCreate User: 3");
        try {
            result = Integer.parseInt(listen(""));
        } catch (Exception e){
            System.out.println("Wrong answer\n\n\n\n\n\n");
            displayMenu();
        }

        return result;
    }

    public Controller getController() {
        return controller;
    }

    public String listen(String message){

        System.out.print(message + ">>>");
        return scan.nextLine();
    }


    public void displayRoutes() {
        // TODO - implement View.displayRoutes
        throw new UnsupportedOperationException();
    }



    public ArrayList<String> getUserInfo() {
        ArrayList<String> userInfo = new ArrayList<>();
        System.out.println("\nPlease Enter Information below:");
        userInfo.add(listen("Username "));
        userInfo.add(listen("Password "));
        userInfo.add(listen("Firstname "));
        userInfo.add(listen("Lastname "));
        userInfo.add(listen("Email "));
        userInfo.add(listen("Address "));
        userInfo.add(listen("Phone Number "));
        userInfo.add(listen("Date of Birth(YYYY-MM-DD) "));
        userInfo.add(listen("Passport Number "));
        userInfo.add(listen("Passport Expiration (YYYY-MM-DD) "));

        return userInfo;
    }

    public User getUser() {
        return user;
    }

    @Override
    public void update() {

    }
}