public class Volo extends Thread{

    private static final int MAX_ITERATION = 2;
    private Aereoporto aereoporto;
    private TipoVolo type;

    public Volo(String name, Aereoporto aereoporto, TipoVolo type){
        super(name);
        this.aereoporto = aereoporto;
        this.type = type;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_ITERATION; i++){

            try {
                //prepara
                sleep(2000);
                if (type == TipoVolo.NAZIONALE){
                    System.out.println(getName() + ": richiede Gate nazionale");
                    aereoporto.acquisisciGateNazionale(this);
                }else {
                    System.out.println(getName() + ": richiede gate Internazionale");
                    aereoporto.acquisisciGateInter(this);
                }
                //Volo
                System.out.println(getName() + ": imbarca...");
                sleep(4500);
                //rilascia
                if (type == TipoVolo.NAZIONALE) {
                    aereoporto.rilasciaGateNazionale(this);
                }else {
                    aereoporto.rilasciaGateInter(this);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
