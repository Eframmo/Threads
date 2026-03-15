import java.util.ArrayList;

public class Molo {

    private ArrayList<Casse> molo;
    private final int MAX_VALUE;

    public Molo(int max) {
        this.molo = new ArrayList<>();
        this.MAX_VALUE = max;
    }

    public synchronized void scaricaCassa(Casse casse) throws InterruptedException {
        while (molo.size() == MAX_VALUE) wait();

        System.out.println("Aggiunta una cassa");
        molo.add(casse);
        notifyAll();
    }

    public synchronized void spedisci() throws InterruptedException {
        while (molo.size() < MAX_VALUE) wait();

        molo.clear();
        System.out.println("Spedite tutte le casse");
        notifyAll();
    }
}
