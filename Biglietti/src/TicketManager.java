public class TicketManager {

    private int biglietti;

    public TicketManager(int biglietti) {
        this.biglietti = biglietti;
    }

    public synchronized void compra() {

        if (biglietti > 0){
            biglietti--;
            System.out.println(Thread.currentThread().getName() + " ha comprato un biglietto");
        }else {
            Thread.currentThread().interrupt();
        }
    }
}
