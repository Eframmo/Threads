import java.util.concurrent.ArrayBlockingQueue;

public class Buffer {

    private ArrayBlockingQueue<Integer> spazio;

    public Buffer() {
        this.spazio = new ArrayBlockingQueue<>(1);
    }

    public void modifica(int n){
        spazio.add(n);
    }

    public int prendi() throws InterruptedException {
        return spazio.take();
    }
}
