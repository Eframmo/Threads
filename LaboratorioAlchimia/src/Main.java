import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Laboratorio laboratorio = new Laboratorio(2,2,2);
        ArrayList<Alchimista> alchimisti = new ArrayList<>();

        for (int i = 0; i < 8; i++){
            alchimisti.add(new Alchimista("Alchimista - " + (i+1), laboratorio));
            alchimisti.get(i).start();
        }
    }
}
