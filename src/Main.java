import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args){

        public BigInteger inputPassword; // int max 999,999,999
        public BigInteger pMax;
        int respuesta;
        Scanner sc = new Scanner(System.in);

        imprimirBienvenida();

        //do {
            respuesta = imprimirMenu();

            switch (respuesta){
                case 1:
                    System.out.print("\n\n\tIntroduce un password numérico a descifrar: ");
                    inputPassword = sc.nextBigInteger(); //agregar try catch y validación para int max
                    pMax = inputPassword.toString().length()-1;
                    pMax = (int)pow(10, BigInteger.toString(inputPassword).length())-1; // int pMax 999,999,999
                    ejecutarAlgoritmo(inputPassword, pMax);
                    break;
                case 2:
                    System.out.print("\n\n\t-> Introduce un password numérico a descifrar: ");
                    inputPassword = sc.nextBigInteger(); //agregar try catch y validación para int max
                    pMax = (int)pow(10, Integer.toString(inputPassword).length())-1; // int pMax 999,999,999
                    ejecutarAlgoritmoParalelo(inputPassword, pMax);
                    break;
                default:
                    System.out.println("\nPor favor, fíjate en el dato que introduces :)");
            }
        //}while(respuesta != 666);
    }

    public static void imprimirBienvenida(){
        System.out.println("\n\n:: Programación Paralela aplicada a Seguridad Computacional ::");

        System.out.println("\n\t\t\t\t\t\tBienvenido!");
        System.out.println("\nEl siguiente programa tiene como propósito mostrar los beneficios de la programación paralela, para ello" +
                " se desarrolló una pequeña aplicación orientada a la Seguridad Computacional.");

        System.out.println("\n\n:: Alumnos ::");
        System.out.println("\n\tEspinosa Arias Daniel.");
        System.out.println("\tGonzález Sainz Sergio Abraham.");

        System.out.println("\n\n* - * - * - * - * - * - * - * - * - * - * - *");
    }

    public static int imprimirMenu(){
        System.out.println("\n\n:: MENÚ ::");
        System.out.println("\n\t1. Ejecutar algoritmo.");
        System.out.println("\t2. Ejecutar algoritmo en paralelo.");

        Scanner sc = new Scanner(System.in);

        System.out.print("\n\t\t\t\t-> INTRODUCIR OPCIÓN A EJECUTAR: ");
        int respuesta = sc.nextInt();

        return respuesta;
    }

    public static void limpiarPantalla(){
        for (int i=0; i<20; i++){
            System.out.println();
        }
    }

    public static void ejecutarAlgoritmo(int p, int pMax){
        GeneradorNum g0 = new GeneradorNum(p, Integer.toString(p).length(), 0, pMax);
        g0.start();
    }

    public static void ejecutarAlgoritmoParalelo(int p, int pMax){
        GeneradorNum g1 = new GeneradorNum(p, Integer.toString(p).length(), 0, pMax/4);
        GeneradorNum g2 = new GeneradorNum(p, Integer.toString(p).length(), pMax/4, pMax/2);
        GeneradorNum g3 = new GeneradorNum(p, Integer.toString(p).length(),pMax/2, 3*(pMax/4));
        GeneradorNum g4 = new GeneradorNum(p, Integer.toString(p).length(),3*(pMax/4), pMax);

        g1.start();
        g2.start();
        g3.start();
        g4.start();
    }
}
