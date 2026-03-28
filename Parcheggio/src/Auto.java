import java.util.Random;

public class Auto extends Thread{

    private Parking parking;

    public Auto(String name,Parking parking) {
        setName(name);
        this.parking = parking;
    }

    @Override
    public void run() {
        try {
            int ran = new Random().nextInt(3000) + 2000;
            System.out.println(currentThread().getName() + ": sta guidando per " + ran + " milli secondi");
            Thread.sleep(ran);

            parking.entra();

            ran = new Random().nextInt(5000)+3000;
            System.out.println(currentThread().getName() + ": rimarra nel parcheggio per " + ran + " millisecondi");
            sleep(ran);

            parking.esci();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
