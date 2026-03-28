import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking(5);
        ArrayList<Auto> autos = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            autos.add(new Auto("Auto - " + (i+1), parking));
            autos.get(i).start();
        }
    }
}
