import javax.swing.*;

public class ViewAdminMenu {

    ControllerAdministration controllerAdministration;

    private JPanel adminMenu;
    private JButton viewCurrentRoutesAndButton;
    private JButton addModifyRemoveTranshitHubButton;
    private JButton addModifyRemoveRouteButton;
    private JButton addModifyRemoveCompanyButton;

    public ViewAdminMenu(ControllerAdministration controllerAdministration) {
        this.controllerAdministration = controllerAdministration;




    }

    public JPanel getAdminMenu() {
        return adminMenu;
    }


}
