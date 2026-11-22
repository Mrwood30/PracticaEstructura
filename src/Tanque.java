public class Tanque {
    private String nombre;
    private double capacidadBls;
    private double nivelActualBls;


    public void mostrarInfo(){
        System.out.println("Tanque: " + nombre + " | capacidadBls: " + capacidadBls+ " | nivelActualBls: " + nivelActualBls);

    }

    public double calcularPorcentajeLleno(){
        return ((nivelActualBls/capacidadBls)*100);
      
    }

}