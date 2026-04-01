import java.util.Random;

public class BarrierThread extends Thread{

    private BarrieraSincronizzata barrieraSincronizzata;

    public BarrierThread(String nome, BarrieraSincronizzata barrieraSincronizzata) {
        this.barrieraSincronizzata = barrieraSincronizzata;
        setName(nome);
    }

    @Override
    public void run() {
        int ran = new Random().nextInt(3000)+2000;
        System.out.println(currentThread().getName() + ": lavora per " + (ran/1000) + " secondi");


        try {
            sleep(ran);
            barrieraSincronizzata.entrataBarriera();
            System.out.println(getName() + ": ha finito");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
