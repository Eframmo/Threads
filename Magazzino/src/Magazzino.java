import java.awt.*;
import java.security.spec.RSAOtherPrimeInfo;

public class Magazzino {

    private int pacchi;
    private final int CAPACITA_MAX;
    private int tentativi;

    public Magazzino(int CAPACITA_MAX) {
        pacchi = 0;
        this.CAPACITA_MAX = CAPACITA_MAX;
    }

    public synchronized void rilascia() throws InterruptedException {
        while (pacchi == CAPACITA_MAX){
            wait();
        }

        pacchi++;
        System.out.println(Thread.currentThread().getName() + ": lascia un pacchetto");
        notifyAll();
    }

    public synchronized void preleva() throws InterruptedException {
        long inizio = System.currentTimeMillis();
        while (pacchi == 0){
            if (4000 - (System.currentTimeMillis() - inizio) > 0){
                wait(4000 - (System.currentTimeMillis() - inizio));
            }else {
                tentativi++;
                System.out.println(Thread.currentThread().getName() + ": ha tentato " + tentativi + " volta");
                inizio = System.currentTimeMillis();
            }

            if (tentativi == 3) break;
        }

        if (tentativi < 3){
            tentativi = 0;

            pacchi--;
            System.out.println(Thread.currentThread().getName() + ": prende un pacco");
            notifyAll();
        }else {
            System.out.println(Thread.currentThread().getName() + ": ha finito");
            Thread.currentThread().interrupt();
        }
    }
}
