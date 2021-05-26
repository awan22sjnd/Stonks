package Main;

import Main.Requests.ResponseGenerator;
import Windows.Login;
import Windows.MainWindow;
import org.apache.hc.core5.http.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class UserInterface {

    private JFrame frame;
    public Login login;
    public MainWindow mainWindow;


    public UserInterface(ResponseGenerator generator) throws IOException, ParseException, org.json.simple.parser.ParseException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        login = new Login(this,generator);
        mainWindow = new MainWindow(this,generator);
    }

    public void launch() {
        frame = new JFrame();//creating instance of JFrame
        frame.setContentPane(login.mainPanel); //set the pane to login panel
        frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void changePanel(JPanel panel) {
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }
}