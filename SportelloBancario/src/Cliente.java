import java.util.Random;

public class Cliente extends Thread{

    private Sportello sportello;

    public Cliente(String nome, Sportello sportello) {
        setName(nome);
        this.sportello = sportello;
    }

    @Override
    public void run() {
        try {
            if (sportello.prendiCassa()){
                int ran = new Random().nextInt(2000)+2000;
                System.out.println(getName() + ": sta nella cassa per " + (ran/1000) + " secondi");
                sleep(ran);

                sportello.lasciaCassa();
            }else {
                System.out.println(getName() + ": si è stancato");
            }
        } catch (InterruptedException e) {
            interrupt();
        }
    }
}
