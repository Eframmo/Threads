import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        BarrieraSincronizzata barrieraSincronizzata = new BarrieraSincronizzata();
        ArrayList<BarrierThread> threads = new ArrayList<>();

        for (int i = 0; i < 6; i++){
            threads.add(new BarrierThread("Thread-" + (i+1), barrieraSincronizzata));
            threads.get(i).start();
        }
    }
}
