import java.util.Random;

public class Alchimista extends Thread{

    private Laboratorio laboratorio;

    public Alchimista(String nome, Laboratorio laboratorio) {
        setName(nome);
        this.laboratorio = laboratorio;
    }

    @Override
    public void run() {
        int ran = new Random().nextInt(2000)+1000;
        System.out.println(getName() + ": studia per " + (ran/1000) + " secondi");

        try {
            sleep(ran);
            laboratorio.acquisisciStrumenti();

            ran = new Random().nextInt(3000)+3000;
            sleep(ran);

            laboratorio.restituisci();
        } catch (InterruptedException e) {
            interrupt();
        }
    }
}
