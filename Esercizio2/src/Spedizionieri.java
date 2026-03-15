public class Spedizionieri extends Thread {

    private String nome;
    private Molo molo;

    public Spedizionieri(String nome, Molo molo) {
        setName(nome);
        this.molo = molo;
    }

    @Override
    public void run() {
        for (int i = 0; i< 10; i++){
            try {
                molo.spedisci();
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
