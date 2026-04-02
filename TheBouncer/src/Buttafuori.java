import java.util.Random;

public class Buttafuori {

    private final int MAX_SIZE;
    private int nPersone;

    public Buttafuori(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        this.nPersone = 0;
    }

    public synchronized void entrataLocale(Utente utente) throws InterruptedException {
        if (utente.getEta() < 18) {
            throw new InterruptedException("Non ha l'eta giusta");
        }

        while (nPersone == MAX_SIZE) {
            System.out.println(Thread.currentThread().getName() + ": in attesa");
            wait();
        }

        int rand = new Random().nextInt(5000);
        System.out.println(Thread.currentThread().getName() + ": rimmarra nel locale per " + (rand/1000) + " secondi");
        Thread.sleep(rand);
        notifyAll();

        System.out.println(Thread.currentThread().getName() + ": ha finito");
        utente.interrupt();
    }
}
