package Exercises.Parking;

import java.util.Random;

public class Veicolo extends Thread {

    private Random rand;
    private ParkingLot parkingLot;
    private VehicolType type;

    public VehicolType getType(){
        return type;
    }

    public Veicolo(String name, ParkingLot parkingLot, VehicolType type) {
        setName(name);
        this.rand = new Random();
        this.parkingLot = parkingLot;
        this.type = type;
    }

    @Override
    public void run() {
        try {

            //1. Guida per un po ' [2, 5]sec
            int driveTime = 2000 + rand.nextInt(3001);
            System.out.println(getName() + " sta guidando per " + driveTime / 1000 + " sec.");
            sleep(driveTime);

            //2. Cerca di entrare nel parcehggio ???
            parkingLot.enter(this);
            int parkTime = 3000 + rand.nextInt(5001);
            sleep(parkTime);
            System.out.println(getName() + " parcheggiata per " + parkTime / 1000 + "sec.");

            parkingLot.exit(this);

        } catch (InterruptedException e) {
            interrupt();
        }
    }
}
