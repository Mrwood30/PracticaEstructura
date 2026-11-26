package terminal;

import terminal.modelo.Tanque;

public class App {

    public static void main(String[] args) throws Exception {
       /*  Tanque tanque1 = new Tanque("TK 1", 1000000, 800000);
        Tanque tanque2 = new Tanque("TK 002", 1500000, 1350000);
        Tanque tanque3 = new Tanque("TK 003", 5000, 9000); */
        Tanque tanque4 = new Tanque("TK 04", 0, 50);

       /*  tanque1.mostrarInfo();
        System.out.println(tanque1.calcularPorcentajeLleno());

        /* tanque2.mostrarInfo();
        System.out.println(tanque2.calcularPorcentajeLleno());

        tanque3.mostrarInfo();
        System.out.println(tanque3.calcularPorcentajeLleno()); */

        tanque4.mostrarInfo();
        System.out.println(tanque4.calcularPorcentajeLleno()); 
    }

}
