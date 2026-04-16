public class Main {
    public static void main(String[] args) {

        Buffer b1 = new Buffer();
        Buffer b2 = new Buffer();
        Buffer b3 = new Buffer();
        Buffer b4 = new Buffer();

        Stadio s1 = new Stadio(1, b1,b1, TipoStadio.GENERATORE);
        Stadio s2 = new Stadio(1, b1, b2, TipoStadio.NORMALE);
        Stadio s3 = new Stadio(1, b2, b3, TipoStadio.NORMALE);
        Stadio s4 = new Stadio(1, b3, b4, TipoStadio.NORMALE);
        Stadio s5 = new Stadio(1, b4, b4, TipoStadio.COLLETTORE);

        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
    }
}
