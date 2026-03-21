import java.util.Random;

public class Oggetti {

    private boolean legale;

    public Oggetti() {
        this.legale = new Random().nextBoolean();
    }

    public boolean isLegale() {
        return legale;
    }
}
