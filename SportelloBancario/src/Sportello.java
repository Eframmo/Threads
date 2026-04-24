public class Sportello {

    private int casse;

    public Sportello(int casse) {
        this.casse = casse;
    }

    public synchronized boolean prendiCassa() throws InterruptedException {
        long inizio = System.currentTimeMillis();
        while (casse == 0){
            if (5000 - (System.currentTimeMillis() - inizio) < 0) return false;

            wait(5000-(System.currentTimeMillis()-inizio));
        }

        casse--;
        return true;
    }

    public synchronized void lasciaCassa(){
        casse++;
        System.out.println(Thread.currentThread().getName() + ": se ne va");
        notifyAll();
    }
}
