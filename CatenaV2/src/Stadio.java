import java.util.Random;

public class Stadio extends Thread{

    private int n;
    private Buffer bufferEntrata;
    private Buffer bufferUscita;
    private final TipoStadio tipoStadio;

    public Stadio(int n, Buffer bufferEntrata, Buffer bufferUscita, TipoStadio tipoStadio) {
        this.n = n;
        this.bufferEntrata = bufferEntrata;
        this.bufferUscita = bufferUscita;
        this.tipoStadio = tipoStadio;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++){
                switch (tipoStadio){
                    case GENERATORE:
                        bufferEntrata.modifica(new Random().nextInt(10));
                        sleep(1000);
                        break;

                    case NORMALE:
                        int nPreso = bufferEntrata.prendi();
                        sleep(1000);
                        bufferUscita.modifica(nPreso+n);
                        break;

                    case COLLETTORE:
                        System.out.println("Il numero finale è: " + bufferUscita.prendi());
                        break;
                }
            }
        }catch (InterruptedException e){
            interrupt();
        }

    }
}
