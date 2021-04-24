import javax.swing.*;

public class ViewClientMenu {

    ControllerClient controllerClient;
    private JPanel panel1;
    private JButton viewAvailableRoutesButton;
    private JButton yourReservationsButton;
    private JButton payASeatButton;


    public ViewClientMenu(ControllerClient controllerClient) {
        this.controllerClient = controllerClient;
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
