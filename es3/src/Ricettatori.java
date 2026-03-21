public class Ricettatori extends Thread{

    private Mercato mercato;

    public Ricettatori(String nome, Mercato mercato) {
        setName(nome);
        this.mercato = mercato;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                mercato.removeOggetto(false);
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
