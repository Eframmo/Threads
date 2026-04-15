public class Buffer {

    private int n;
    private boolean isPieno;

    private boolean isPrimo;
    private boolean isUltimo;

    public Buffer(boolean isPrimo, boolean isUltimo) {

        this.isPieno = false;
        this.isPrimo = isPrimo;
        this.isUltimo = isUltimo;
    }

    public synchronized void modifica(int modifica) throws InterruptedException {
        while (isPieno){
            System.out.println(Thread.currentThread().getName() + ": aspetta a modificare");
            wait();
        }

        n = modifica;
        notifyAll();
        isPieno = true;

        System.out.println(Thread.currentThread().getName() + ": ha modificato");
    }

    public synchronized int prendiValore() throws InterruptedException {
        while (!isPieno){
            System.out.println(Thread.currentThread().getName() + ": aspetta l'arrivo di un valore");
            wait();
        }

        isPieno = false;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + ": ha preso");

        return n;
    }

    public synchronized void inizializza(){
        if (this.isPrimo){
            n = 0;
            isPieno = true;
        }
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setPieno(boolean pieno) {
        isPieno = pieno;
    }

    public void setPrimo(boolean primo) {
        isPrimo = primo;
    }

    public void setUltimo(boolean ultimo) {
        isUltimo = ultimo;
    }

    public int getN() {
        return n;
    }

    public boolean isPieno() {
        return isPieno;
    }

    public boolean isPrimo() {
        return isPrimo;
    }

    public boolean isUltimo() {
        return isUltimo;
    }
}
