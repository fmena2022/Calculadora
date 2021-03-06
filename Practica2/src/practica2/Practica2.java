/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import java.util.Scanner;

/**
 *
 * @author esther
 */
public class Practica2 {

    /**
     * @param args the command line arguments
     */
        static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        double res = 0;
        String operacion;
        boolean comprobar = false;

        do {

            String numero1;
            do {
                System.out.println("\nIntrodueix el primer numero. ");
                numero1 = sc.nextLine();
            } while (!numero1.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume1 = Double.parseDouble(numero1);
            double n1 = new Double(numero1);

            do {
                System.out.println("\nOperació? (Indica el signe)");
                System.out.println("+ = sumar \n - = restar \n"
                        + " x = multiplicar \n / = dividir \n * = elevar primer num al segon num."
                        + "\n % = residu");
                operacion = sc.nextLine();
                if (operacion.equals("+") || operacion.equals("-") || operacion.equals("x")
                        || operacion.equals("X") || operacion.equals("/") || operacion.equals("%")
                        || operacion.equals("*")) {
                    comprobar = true;
                } else {
                    comprobar = false;
                }
            } while (comprobar != true);

            String numero2;
            do {
                System.out.println("\nIntrodueix el segon numero.");
                numero2 = sc.nextLine();
            } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
            double nume2 = Double.parseDouble(numero2);
            double n2 = new Double(numero2);

            do {
                comprobar = true;
                res = calcul(n1, n2, operacion, res, numero2, nume2);
            }
            while (comprobar != true);

            System.out.println("(" + numero1 + ") " + operacion + " (" + numero2 + ")" + " = " + res);
            System.out.println("\nVols continuar operant? \n");
            System.out.println(" [s/n]");
            do {
                comprobar = true;
                operacion = sc.nextLine();

                switch (operacion) {
                    case "s":
                    case "S":
                    case "n":
                    case "N":
                        break;
                    default:
                        System.err.println("\nError, posa un valor vàlid. \n");
                        comprobar = false;
                }
            } while (comprobar != true);
        } while (operacion.equals("s") || operacion.equals("S"));
    }
    public static double calcul(double n1, double n2, String operacion, double res, String numero2, double nume2) {
        switch (operacion) {
            case "+":
                res = n1 + n2;
                break;
            case "-":
                res = n1 - n2;
                break;
            case "x":
            case "X":
                res = n1 * n2;
                break;
            case "/":
                while (n2 == 0) {
                    do {
                        System.err.println("Al denominador hi ha un zero \n"
                                + "per a  evitar errors coloca un altre valor.");
                        numero2 = sc.nextLine();
                    } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                    nume2 = Double.parseDouble(numero2);
                    n2 = new Double(numero2);
                }
                res = n1 / n2;
                break;
            case "*":
                res = Math.pow(n1, n2);
                break;
            case "%":
                while (n2 == 0) {
                    do {
                        System.err.println("Al denominador hi ha un zero \n"
                                + "per a  evitar errors coloca un altre valor.");
                        numero2 = sc.nextLine();
                    } while (!numero2.matches("[+-]?[\\d]*[.]?[\\d]+"));
                    nume2 = Double.parseDouble(numero2);
                    n2 = new Double(numero2);
                }
                res = n1 % n2;
                break;
        }
        return res;
    }
}

