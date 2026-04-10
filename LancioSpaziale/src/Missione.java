import java.util.Random;

public class Missione extends Thread{

    private CentroLancio centroLancio;

    public Missione(String codice, CentroLancio centroLancio) {
        setName(codice);
        this.centroLancio = centroLancio;
    }

    @Override
    public void run() {
        int ran = new Random().nextInt(2000)+1000;
        System.out.println(getName() + ": si sta preparando per " + (ran/1000) + " secondi");
        try {
            sleep(ran);
            centroLancio.acquisisciRisorse();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
