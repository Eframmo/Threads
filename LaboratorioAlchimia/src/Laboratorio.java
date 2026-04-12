public class Laboratorio {

    private int fornaci;
    private int tavoli;
    private int cappe;

    public Laboratorio(int fornaci, int tavoli, int cappe) {
        this.fornaci = fornaci;
        this.tavoli = tavoli;
        this.cappe = cappe;
    }

    public synchronized void acquisisciStrumenti() throws InterruptedException {
        while (fornaci == 0 || tavoli == 0 || cappe == 0){
            System.out.println(Thread.currentThread().getName() + ": aspetto gli strumenti");
            wait();
        }

        fornaci--;
        tavoli--;
        cappe--;

        System.out.println(Thread.currentThread().getName() + ": inizia a lavorare ");
    }

    public synchronized void restituisci(){
        fornaci++;
        cappe++;
        tavoli++;

        notifyAll();
        System.out.println(Thread.currentThread().getName() +": ha finito");
    }
}
