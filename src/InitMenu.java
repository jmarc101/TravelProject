import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitMenu {
    private JButton adminButton;
    private JPanel panelInit;
    private JButton clientButton;
    private JLabel result;
    private JTextArea choice;

    public InitMenu() {
        adminButton.addActionListener(e -> result.setText("Admin Clicked"));
        clientButton.addActionListener(e -> result.setText("Client Clicked"));
    }
}
