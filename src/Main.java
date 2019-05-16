public class Main {
    public static void main(String[] args){

        String p1 = "passdea";

        GeneradorSimpleThread g1 = new GeneradorSimpleThread(p1, p1.length());

        g1.start();
    }
}