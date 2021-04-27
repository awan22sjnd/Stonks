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

}