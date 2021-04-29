package Main;

import Windows.Login;
import Windows.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class UserInterface {

    private Scanner reader;
    private JFrame frame;
    public Login login;
    public MainWindow mainWindow;
    private Stonks wrapper;


    public UserInterface(Stonks stonks){
        wrapper = stonks;
        reader = new Scanner(System.in);
        login = new Login(this);
        mainWindow = new MainWindow(this);
    }

    public void launch() {
        frame = new JFrame();//creating instance of JFrame
        frame.setContentPane(login.mainPanel); //set the pane to login panel
        frame.setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void changePanel(JPanel panel){
        frame.setContentPane(panel);
        frame.revalidate();
        frame.repaint();
    }


    public String input (){
        System.out.println("Please input a valid stock ticker! If you would like to quit, type 'quit' to quit.");
        String ticker = reader.nextLine();
        return ticker;
    }

    public void displayBasicData(Response res){
        System.out.println(res.getTicker()+" is "+res.getPrice());
    }

    //TODO Implement error handling well
    public String displayError(String msg){
        if(msg!="valid") {
            System.out.println("Unkown Failure Occured");
        }
        return "null";
    }

    public Stonks getWrapper() {
        return wrapper;
    }
}