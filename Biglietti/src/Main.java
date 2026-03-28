import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        TicketManager ticketManager = new TicketManager(10);
        ArrayList <Buyer> buyers = new ArrayList<>();

        for (int i = 0; i < 20; i++){
            buyers.add(new Buyer("compratore - " + (i+1), ticketManager));
            buyers.get(i).start();
        }
    }
}
