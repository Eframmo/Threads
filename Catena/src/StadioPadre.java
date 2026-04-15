public abstract class StadioPadre extends Thread{

    protected Buffer bufferEntrata;
    protected Buffer bufferUscita;

    protected int n;

    public StadioPadre(String nome, Buffer bufferEntrata, Buffer bufferUscita, int n) {
        setName(nome);
        this.bufferEntrata = bufferEntrata;
        this.bufferUscita = bufferUscita;
        this.n = n;
    }

    public abstract int trasforma(int modifica);

    @Override
    public void run() {
        for (int i = 0; i < 10; i++){
            bufferEntrata.inizializza();

            try {
                if (bufferEntrata.equals(bufferUscita)){
                    System.out.println(trasforma(bufferEntrata.prendiValore()));
                }else {
                    bufferUscita.modifica(trasforma(bufferEntrata.prendiValore()));
                }

                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
