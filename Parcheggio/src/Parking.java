import java.util.Random;

public class Parking {

    private int posti;

    public Parking(int MAX_SIZE) {
        posti = MAX_SIZE;
    }

    public synchronized void entra() throws InterruptedException {
        while (posti <= 0) {
            System.out.println(Thread.currentThread().getName() + ": aspetta di entrare");
            wait();
        }
        posti--;
    }

    public synchronized void esci(){
        System.out.println(Thread.currentThread().getName() + ": sta uscendo");
        posti++;
        notifyAll();
    }
}
