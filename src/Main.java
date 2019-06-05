import java.util.Scanner;

import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args){

        double inputPassword; // int max 999,999,999
        double pMax;
        int respuesta;
        Scanner sc = new Scanner(System.in);

        imprimirBienvenida();

        //do {
            respuesta = imprimirMenu();

            switch (respuesta){
                case 1:
                    System.out.print("\n\n\tIntroduce un password numérico a descifrar: ");
                    inputPassword = sc.nextDouble(); //agregar try catch y validación para int max
                    pMax = pow(10, Double.toString(inputPassword).length()-2)-1; // int pMax 999,999,999
                    ejecutarAlgoritmo(inputPassword, pMax);
                    break;
                case 2:
                    System.out.print("\n\n\t-> Introduce un password numérico a descifrar: ");
                    inputPassword = sc.nextDouble(); //agregar try catch y validación para int max
                    pMax = pow(10, Double.toString(inputPassword).length()-2)-1; // int pMax 999,999,999
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

    public static void ejecutarAlgoritmo(double p, double pMax){
        GeneradorNum g0 = new GeneradorNum(p,0, pMax);
        g0.start();
    }

    public static void ejecutarAlgoritmoParalelo(double p, double pMax){
        GeneradorNum g1 = new GeneradorNum(p,0, pMax/4);
        GeneradorNum g2 = new GeneradorNum(p,pMax/4, pMax/2);
        GeneradorNum g3 = new GeneradorNum(p,pMax/2, 3*(pMax/4));
        GeneradorNum g4 = new GeneradorNum(p,3*(pMax/4), pMax);

        g1.start();
        g2.start();
        g3.start();
        g4.start();
    }
}
