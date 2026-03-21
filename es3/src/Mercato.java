import java.util.ArrayList;

public class Mercato {

    private ArrayList<Oggetti> mercato;
    private final int MAX;

    public Mercato(int max) {
        this.mercato = new ArrayList<>();
        this.MAX = max;
    }

    public synchronized void addOggetto() throws InterruptedException {
        while (mercato.size() == MAX) {
            System.out.println(Thread.currentThread().getName() + ": mercato pieno");
            wait();
        }

        mercato.add(new Oggetti());
        System.out.println(Thread.currentThread().getName() + " ha aggiunto qualcosa al mercato ");
        notifyAll();
    }

    public synchronized void removeOggetto(boolean legale) throws InterruptedException {
        while (mercato.size() == 0){
            System.out.println(Thread.currentThread().getName() + ": mercato vuoto");
            wait();
        }

        for (int i = 0; i < mercato.size(); i++){
            if (mercato.get(i).isLegale() == legale){
                mercato.remove(i);
                System.out.println(Thread.currentThread().getName() + " ha rimosso un oggetto");
                notifyAll();
                break;
            }
        }

    }

    public ArrayList<Oggetti> getMercato() {
        return mercato;
    }
}
