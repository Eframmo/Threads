import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Aereoporto {

    private int gateNazionaliTotali;
    private int gateInternazionaliTotali;

    // synchronized = Lock + condizione
    private final ReentrantLock lock;
    private final Condition attendiNazionali;
    private final Condition attendiInternazioni;
    private int gateNazionaliLiberi;
    private int gateInternazionaliLiberi;

    public Aereoporto(int gateNazionaliTotali, int gateInternazionaliTotali) {
        this.gateNazionaliTotali = gateNazionaliTotali;
        this.gateNazionaliLiberi = gateNazionaliTotali;
        this.gateInternazionaliTotali = gateInternazionaliTotali;
        this.gateInternazionaliLiberi = gateInternazionaliTotali;
        this.lock = new ReentrantLock();
        this.attendiNazionali = lock.newCondition();
        this.attendiInternazioni = lock.newCondition();
    }


    public void acquisisciGateNazionale(Volo volo) throws InterruptedException {
        lock.lock(); // prendo il lock

        try {
            while (gateNazionaliLiberi==0) attendiNazionali.await();
            gateNazionaliLiberi--;
            System.out.println(volo.getName() + ": prende il gate");
        } finally {
            lock.unlock(); // rilascio il lock
        }
    }

    public void rilasciaGateNazionale(Volo v){
        lock.lock();

        try {
            gateNazionaliLiberi++;
            //notify() = signal
            attendiNazionali.signal();
            System.out.println(v.getName() + ": è andato");
        } finally {
            lock.unlock();
        }

    }

    public void acquisisciGateInter(Volo volo) throws InterruptedException {
        lock.lock();

        try {
            while (gateInternazionaliLiberi == 0) attendiInternazioni.await();
            gateInternazionaliLiberi--;
            System.out.println(volo.getName() + ": prende il gate");
        } finally {
            lock.unlock();
        }
    }

    public void rilasciaGateInter(Volo volo) throws InterruptedException {
        lock.lock();

        try {
            gateInternazionaliLiberi++;
            attendiInternazioni.signal();
            System.out.println(volo.getName() + ": è andato");
        } finally {
            lock.unlock();
        }
    }
}