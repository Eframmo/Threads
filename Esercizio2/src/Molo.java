import java.util.ArrayList;

public class Molo {

    private ArrayList<Casse> molo;
    private final int MAX_VALUE;
    private Mozzi mozzi;
    private Spedizionieri spedi;

    public Molo(int max) {
        this.molo = new ArrayList<>();
        this.MAX_VALUE = max;
        this.mozzi = new Mozzi("mozzo", this);
        this.spedi = new Spedizionieri("spedi", this);
    }

    public void running() throws InterruptedException {

        synchronized (Thread.currentThread()){
            mozzi.start();
            spedi.start();

            while (mozzi.isAlive()) {
                Thread.currentThread().wait();
                notifyAll();
            }
            spedi.interrupt();
            System.out.println("Abbiamo finito");
        }

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
