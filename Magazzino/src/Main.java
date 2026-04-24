import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Magazzino magazzino = new Magazzino(4);
        ArrayList<Operaio> operai = new ArrayList<>();
        Corriere corriere = new Corriere("Corriere", magazzino);

        for (int i = 0; i < 3; i++){
            operai.add(new Operaio("operaio-" + (i+1), magazzino));
            operai.getLast().start();
        }
        corriere.start();
    }
}