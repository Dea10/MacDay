import java.text.DecimalFormat;
import java.util.Random;

public class GeneradorNum extends Thread{
    public double passwordNum;
    public double crackNum;
    public double inicio;
    public double fin;
    Random rand = new Random();
    DecimalFormat df2 = new DecimalFormat("0");

    public GeneradorNum (double crackNum, double inicio, double fin){
        this.crackNum = crackNum;
        this.inicio = inicio;
        this.fin = fin;
    }

    public void run(){
        long startTime = System.nanoTime();

        while (passwordNum!=crackNum){
            passwordNum = generaPassNum();
        }

        long endTime = System.nanoTime();

        System.out.println("\n\nContraseña descifrada: " + df2.format(passwordNum));
        System.out.println("Tiempo: " + ((endTime-startTime)/1e6)/1000 + " seg.\n");

        System.out.println("Thread terminado: " + Thread.currentThread().getName());
        Main.limpiarPantalla();

        detenerPrograma();
    }

    public double generaPassNum(){
        passwordNum = Math.floor(inicio + rand.nextDouble()*(fin-inicio));

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
