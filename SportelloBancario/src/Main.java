import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Sportello sportello = new Sportello(2);
        ArrayList<Cliente> clienti = new ArrayList<>();

        for (int i = 0; i < 8; i++){
            clienti.add(new Cliente("Cliente" + (i+1), sportello));
            clienti.get(i).start();
        }
    }
}