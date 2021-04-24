import javax.swing.*;

public class ViewLoginClient {
    ControllerClient controllerClient;
    private JPanel panel1;
    private JTextField username;
    private JTextField password;
    private JButton connexionButton;
    private JLabel result;

    public ViewLoginClient(ControllerClient controllerClient) {
        this.controllerClient = controllerClient;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JButton getConnexionButton() {
        return connexionButton;
    }

    public boolean validate(){
        User user = (User) controllerClient.userManager.read(username.getText());
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
