public class App {

    public static void main(String[] args) throws Exception {
        Tanque tanque1 = new Tanque("TK 001", 1000000, 800000);
        Tanque tanque2 = new Tanque("TK 002", 1500000, 1350000);

        tanque1.mostrarInfo();
        System.out.println(tanque1.calcularPorcentajeLleno());

        tanque2.mostrarInfo();
        System.out.println(tanque2.calcularPorcentajeLleno());

    }
      

}
