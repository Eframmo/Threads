public class Buyer extends Thread{

    private TicketManager ticketManager;

    public Buyer(String nome, TicketManager ticketManager) {
        setName(nome);
        this.ticketManager = ticketManager;
    }

    @Override
    public void run() {
        while (!currentThread().isInterrupted()){
            ticketManager.compra();
            currentThread().yield();
        }

        System.out.println(currentThread().getName() + ": biglietti finiti");
    }
}
