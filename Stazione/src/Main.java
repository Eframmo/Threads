import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Stazione stazione = new Stazione("Stazione", 3);
        ArrayList<Treno> treni = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            treni.add(new Treno("Treno-"+(i+1), stazione));
            treni.getLast().start();
        }
    }
}
