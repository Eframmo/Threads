package Exercises.Parking;

//enum = collezioni/classi di valori costanti
//associeremo ad ogni type/tipo la sua grandezza
public enum VehicolType {
    AUTO(1),MOTO(1),CAMION(2), AUTUBUS(3);

    private final int postiOccupati;

    VehicolType(int postiOccupati) {
        this.postiOccupati = postiOccupati;
    }

    public int getPostiOccupati() {
        return postiOccupati;
    }
}
