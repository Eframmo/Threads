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

    }

    public synchronized void rilascioRisorse() throws InterruptedException {
        rampe++;
        torri++;
        notifyAll();
    }
}
