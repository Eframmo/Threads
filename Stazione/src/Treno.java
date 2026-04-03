import java.util.Random;

public class Treno extends Thread{

    private Stazione stazione;

    public Treno(String codice, Stazione stazione) {
        setName(codice);
        this.stazione = stazione;
    }

    @Override
    public void run() {

        int ran = new Random().nextInt(3000) + 2000;
        System.out.println(getName() + ": viaggia per " + (ran/1000) + " secondi");
        try {
            sleep(ran);
            stazione.entrataTreno();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
