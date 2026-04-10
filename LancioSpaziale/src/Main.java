import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CentroLancio centroLancio = new CentroLancio(3,2);
        ArrayList<Missione> missioni = new ArrayList<>();

        System.out.println((int) System.currentTimeMillis());
        for (int i = 0; i < 10; i++){
            missioni.add(new Missione("Missione - " + (i+1), centroLancio));
            missioni.get(i).start();
        }
    }
}