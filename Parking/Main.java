package Exercises.Parking;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //1. Tempo max di simulazione. il pacheggio chiude dopo F secondi.
        //2. Non tutte i veicoli sono uguali. alcuni occupano 1 posto, altri 2, altre 3.

        ParkingLot parkingLot = new ParkingLot(5);

        List<Veicolo> autos = new ArrayList<>();
        final int MAX_AUTO = 10;

        for (int i = 0; i < MAX_AUTO; i++) autos.add(new Veicolo("Auto-" + (i + 1), parkingLot));

        for(Veicolo a : autos) a.start();
        for(Veicolo a : autos) a.join();

        System.out.println("FINE");


    }
}
