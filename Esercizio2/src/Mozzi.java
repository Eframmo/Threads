public class Mozzi extends Thread{

    private String nome;
    private Molo molo;

    public Mozzi(String nome, Molo molo) {
        setName(nome);
        this.molo = molo;
    }

    @Override
    public void run() {
        for (int i = 0; i< 10; i++){
            try {
                molo.scaricaCassa(new Casse("Cassa di legno", 5));
            } catch (InterruptedException e) {
                interrupt();
            }
        }

    }
}
