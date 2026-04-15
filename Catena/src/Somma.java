public class Somma extends StadioPadre{

    public Somma(String nome, Buffer bufferEntrata, Buffer bufferUscita, int n) {
        super(nome, bufferEntrata, bufferUscita, n);
    }

    @Override
    public int trasforma(int modifica) {
        return modifica+n;
    }
}
