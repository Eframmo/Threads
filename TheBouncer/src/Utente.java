public class Utente extends Thread{

    private int eta;
    private Buttafuori buttafuori;

    public Utente(String nome,int eta, Buttafuori buttafuori) {
        setName(nome);
        this.eta = eta;
        this.buttafuori = buttafuori;
    }

    @Override
    public void run() {
        while (!currentThread().isInterrupted()){
            try {
                buttafuori.entrataLocale(this);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": non ha l'eta giusta");
                break;
            }
        }
    }

    public int getEta() {
        return eta;
    }
}
