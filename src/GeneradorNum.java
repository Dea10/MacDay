import java.math.BigInteger;
import java.util.Random;

public class GeneradorNum extends Thread{
    public BigInteger passwordNum;
    public BigInteger crackNum;
    public BigInteger inicio;
    public BigInteger fin;
    Random rand = new Random();

    public GeneradorNum (BigInteger crackNum, BigInteger inicio, BigInteger fin){
        this.crackNum = crackNum;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void run(){
        long startTime = System.nanoTime();

        while (passwordNum.equals(crackNum)){
            passwordNum = generaPassNum();
        }

        long endTime = System.nanoTime();

        System.out.println("\n\nContraseña descifrada: " + passwordNum);
        System.out.println("Tiempo: " + ((endTime-startTime)/1e6)/1000 + " seg.\n");

        System.out.println("Thread terminado: " + Thread.currentThread().getName());
        Main.limpiarPantalla();

        detenerPrograma();
    }

    public BigInteger generaPassNum(){
        //passwordNum = 0;

        /*
        for (i=0; i<tam; i++){
            //passwordNum = rand.nextInt((int)pow(10, tam)-1);

        }
*/
        //passwordNum = rand.nextInt(fin-inicio+1)+inicio;
        passwordNum = BigInteger(fin.bitLength(), rand); //va a estar calculando todos desde 0, evitar eso!!!!!
        //cambiar por un generador secuencial y no al azar

//        for(i=inicio; i<fin; i++){
 //           passwordNum++;
   //     }

        return passwordNum;
    }

    public void limpiarPantalla(){
        for (int i=0; i<40; i++){
            System.out.println();
        }
    }

    public void detenerPrograma(){
        System.exit(0);
    }
}
