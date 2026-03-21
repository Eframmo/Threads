public class Commercianti extends Thread{

    private Mercato mercato;

    public Commercianti(String nome, Mercato mercato) {
        setName(nome);
        this.mercato = mercato;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                mercato.removeOggetto(true);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
