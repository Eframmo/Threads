public class Contrabbandieri extends Thread{

    private Mercato mercato;

    public Contrabbandieri(String nome, Mercato mercato) {
        setName(nome);
        this.mercato = mercato;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            try {
                mercato.addOggetto();
            } catch (InterruptedException e) {
                interrupt();
            }
        }
    }
}
