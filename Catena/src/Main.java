public class Main {
    public static void main(String[] args) {

        Buffer b1 = new Buffer(true, false);
        Buffer b2 = new Buffer(false, false);
        Buffer b3 = new Buffer(false,true);

        Somma s1 = new Somma("s1", b1,b2,1);
        Somma s2 = new Somma("s2", b2, b3, 2);
        Somma s3 = new Somma("s3",b3,b3,3);

        s1.start();
        s2.start();
        s3.start();
    }
}
