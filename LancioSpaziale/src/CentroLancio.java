import java.util.Random;

public class CentroLancio {

    private int rampe;
    private int torri;

    public CentroLancio(int rampe, int torre) {
        this.rampe = rampe;
        this.torri = torre;
    }

    public synchronized void acquisisciRisorse() throws InterruptedException {
        while (rampe == 0 || torri == 0){
            System.out.println(Thread.currentThread().getName() + ": sta aspettando");
            wait();
        }

        rampe--;
        torri--;

        int ran = new Random().nextInt(3000)+2000;
        System.out.println(Thread.currentThread().getName() + ": esegue per " + (ran/1000) + " secondi");

        int inizio = (int) System.currentTimeMillis();
        while ((int) System.currentTimeMillis() - inizio < ran){
            wait(ran-((int) System.currentTimeMillis() - inizio));
        }

        rampe++;
        torri++;
        notifyAll();
    }
}
