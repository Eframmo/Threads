import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Buttafuori buttafuori = new Buttafuori(2);
        ArrayList<Utente> utenti = new ArrayList<>();

        int n = 0;
        for (int i = 15; i < 20; i++){
            utenti.add(new Utente("Utente-" + (n+1), i, buttafuori));
            utenti.get(n).start();
            n++;
        }
    }
}
