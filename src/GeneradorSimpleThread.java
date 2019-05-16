import java.util.Random;

public class GeneradorSimpleThread extends Thread {

    String pass = "";
    String crack = "";
    int[] aa;
    int i, j, tam, aux;
    Random rand = new Random();

    public GeneradorSimpleThread(String crack, int tam){
        this.tam = tam;
        this.crack = crack;
        aa = new int[tam];
    }

    public void run(){
        long startTime = System.nanoTime();

        while (!pass.equals(crack)){
            pass = generaPass();
        }

        long endTime = System.nanoTime();

        System.out.println("Contraseña descifrada: " + pass);
        System.out.println("Tiempo: " + ((endTime-startTime)/1e6)/1000 + " seg.\n");
    }

    public String generaPass(){
        pass = "";

        for (i=0; i<tam; i++){
            aux = rand.nextInt(89) + 33;
            if(aux >= 94 && aux <=96){
                aux+=3;
            }
            aa[i] = aux;
        }

        for (i=0; i<tam; i++) {
            pass += (char) aa[i];
        }
        return pass;
    }

}
