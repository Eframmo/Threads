import java.util.concurrent.Semaphore;

public class BarrieraSincronizzata {

    private int contatore;
    private static Semaphore sem = new Semaphore(3);

    public BarrieraSincronizzata() {
        this.contatore = 0;
    }

    public synchronized void entrataBarriera() throws InterruptedException {

        sem.acquire();
        if (sem.availablePermits() == 0){
            notifyAll();
        }else {
            System.out.println(Thread.currentThread().getName() + ": bloccato");
            wait();
        }

        System.out.println(Thread.currentThread().getName() + ": riprende a lavorare");
        sem.release();
    }
}
