import java.util.Random;

public class Operaio extends Thread{

    private Magazzino magazzino;

    public Operaio(String nome, Magazzino magazzino) {
        setName(nome);
        this.magazzino = magazzino;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++){
                magazzino.rilascia();

                int ran = new Random().nextInt(2000)+1000;
                System.out.println(getName() + ": lavora per " + (ran/1000) + " secondi");
                sleep(ran);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
