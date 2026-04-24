public class Corriere extends Thread{

    private Magazzino magazzino;

    public Corriere(String nome, Magazzino magazzino) {
        setName(nome);
        this.magazzino = magazzino;
    }

    @Override
    public void run() {
        while (isAlive()){
            try {
                magazzino.preleva();
                sleep(1000);
            } catch (InterruptedException e) {
                interrupt();
                break;
            }
        }
    }
}
