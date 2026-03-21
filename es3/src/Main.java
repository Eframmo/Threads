import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Mercato mercato = new Mercato(5);
        ArrayList<Contrabbandieri> contra = new ArrayList<>();
        ArrayList<Commercianti> comm = new ArrayList<>();
        ArrayList<Ricettatori> rice = new ArrayList<>();

        for (int i = 0; i < 3; i++){
            contra.add(new Contrabbandieri("contra" + (i+1), mercato));
            comm.add(new Commercianti("Commerciante" + (i+1), mercato));
            rice.add(new Ricettatori("Ricettatore" + (i+1), mercato));

            comm.get(i).start();
            contra.get(i).start();
            rice.get(i).start();
        }
    }
}
