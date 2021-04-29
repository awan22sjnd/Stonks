public class Stonks {

    private UserInterface ui;

    public static void main(String args[]){
        Stonks app = new Stonks();
        app.run();
    }


    public Stonks(){
        ui = new UserInterface();

    }

    public void run(){
        ui.launch();
    }

    public void live(){

    }

    public void history(){

    }

}
