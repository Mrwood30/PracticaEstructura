public class Tanque {
    private String nombre;
    private double capacidadBls;
    private double nivelActualBls;

public Tanque (String nombre, double capacidadBls, double nivelActualBls){
    this.nombre = nombre;
    this.capacidadBls = capacidadBls;
    this.nivelActualBls = nivelActualBls;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setCapacidadBls(double capacidadBls) {
        if (capacidadBls > 0)
            this.capacidadBls = capacidadBls;
        else
            System.out.println("La capcidad debe ser mayor a cero");
    }

    public double getCapacidadBls() {
        return this.capacidadBls;
    }

    public void mostrarInfo() {
        System.out.println(
                "Tanque: " + nombre + " | capacidadBls: " + capacidadBls + " | nivelActualBls: " + nivelActualBls);

    }

    public double calcularPorcentajeLleno() {
        return ((nivelActualBls / capacidadBls) * 100);

    }

}
