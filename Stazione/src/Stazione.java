import java.util.ArrayList;
import java.util.Random;

public class Stazione {

    private String nome;
    private int nBinari;
    private ArrayList<Boolean> binari;

    public Stazione(String nome, int binari) {
        this.nome = nome;
        this.nBinari = binari;
        this.binari = new ArrayList<>();
    }

    public synchronized void entrataTreno() throws InterruptedException {
        while (binari.size() == nBinari) {
            System.out.println(Thread.currentThread().getName() + ": in attesa di un binario");
            wait();
        }

        binari.addLast(true);

        int ran = new Random().nextInt(3000) + 2000;
        System.out.println(Thread.currentThread().getName() + ": rimmarra nel binario per " + (ran/1000) + " secondi");
        wait(ran);

        binari.removeLast();
        notifyAll();
    }
}
