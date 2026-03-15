public class Main {
    public static void main(String[] args) {

        Molo molo = new Molo(5);
        Mozzi mozzi = new Mozzi("Mozzo", molo);
        Spedizionieri spedi = new Spedizionieri("Amazon", molo);

        mozzi.start();
        spedi.start();

        while (!spedi.isInterrupted()){
            if (mozzi.isInterrupted()){
                System.out.println("Mozzi ha finito, uccisione di amazon");
                spedi.interrupt();
                break;
            }
        }
   }
}
