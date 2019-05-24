import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.pow;

public class GeneradorNum extends Thread{
    public int passwordNum;
    public int crackNum;
    public int tam;
    public int pass;
    public int inicio;
    public int fin;
    public int i, j, aux;
    Random rand = new Random();
    public ArrayList<GeneradorNum> hilos;

    public GeneradorNum (int crackNum, int tam, int inicio, int fin){
        this.tam = tam;
        this.crackNum = crackNum;
        this.inicio = inicio;
        this.fin = fin;
        this.hilos=new ArrayList<>();
    }

    public void run(){
        long startTime = System.nanoTime();

        while (passwordNum != crackNum){
            passwordNum = generaPassNum();
        }

        long endTime = System.nanoTime();

        System.out.println("\n\nContraseña descifrada: " + passwordNum);
        System.out.println("Tiempo: " + ((endTime-startTime)/1e6)/1000 + " seg.\n");

        System.out.println("Thread terminado: " + Thread.currentThread().getName());
        Main.limpiarPantalla();

        detenerPrograma();
    }

    public int generaPassNum(){
        passwordNum = 0;

        for (i=0; i<tam; i++){
            //passwordNum = rand.nextInt((int)pow(10, tam)-1);
            passwordNum = rand.nextInt(fin-inicio+1)+inicio;
        }

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
