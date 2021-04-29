import javax.swing.*;
import java.util.Scanner;
public class UserInterface {

    private Scanner reader;

    public UserInterface(){
        reader = new Scanner(System.in);

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

    public void launch() {
        JFrame f = new JFrame();//creating instance of JFrame

        JButton b=new JButton("click");//creating instance of JButton  
        b.setBounds(130,100,100, 40);

        f.add(b);//adding button in JFrame  

        f.setSize(400,500);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  
    }
}