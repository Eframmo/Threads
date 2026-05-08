

public class Main {
    private static final int GATE_NAZIONALI = 3;
    private static final int GATE_INTERNAZIONALI = 2;

    public static void main(String[] args) throws InterruptedException {
        Aereoporto aereoporto = new Aereoporto(GATE_NAZIONALI, GATE_INTERNAZIONALI);

        Volo[] voli = {
                new Volo("nex-1", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-2", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-3", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-4", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-5", aereoporto, TipoVolo.NAZIONALE),
                new Volo("nex-66", aereoporto, TipoVolo.INTERNAZIONALE),
                new Volo("nex-77", aereoporto, TipoVolo.INTERNAZIONALE),
        };

        for (Volo volo : voli) volo.start();
        for (Volo volo : voli) volo.join();

        System.out.println("END");
    }
}