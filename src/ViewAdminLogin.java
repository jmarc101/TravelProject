import javax.swing.*;

public class ViewAdminLogin {

    ControllerAdministration controllerAdministration;

    private JPanel panel1;
    private JTextField password;
    private JButton connexionButton;
    private JLabel result;
    private JTextField username;

    public ViewAdminLogin(ControllerAdministration controllerAdministration) {
        this.controllerAdministration = controllerAdministration;
    }


    public JPanel getPanel1() {
        return panel1;
    }

    public JButton getConnexionButton() {
        return connexionButton;
    }

    public boolean validate(){
        User user = (User) controllerAdministration.userManager.read(username.getText());
        if (user == null) {
            result.setText("UserName Doesn't Exist");
            return false;
        }
        if (!user.getPassword().equals(password.getText())) {
            result.setText("Wrong Password");
            return false;
        }
        username.setText("");
        password.setText("");
        result.setText("");
        return true;

    }
}
