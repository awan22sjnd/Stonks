package Windows;

import Main.Stonks;
import Main.UserInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public JPanel mainPanel;
    private JButton loginButton;
    private JTextField token;
    private JLabel loginLabel;

    public Login(UserInterface ui) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(token.getText());
                ui.changePanel(ui.mainWindow.mainPanel);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        Stonks stonk = new Stonks();
        frame.setContentPane(new Login(stonk.returnUI()).mainPanel);
        frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
