public class Tanque {
    private String nombre;
    private double capacidadBls;
    private double nivelActualBls;

    public Tanque(String nombre, double capacidadBls, double nivelActualBls) {
        setNombre(nombre);
        setCapacidadBls(capacidadBls);
        setNivelActualBls(nivelActualBls);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setCapacidadBls(double capacidadBls) {
        if (capacidadBls > 0) {
            this.capacidadBls = capacidadBls;
        } else {
            System.out.println("La capacidad debe ser mayor a cero");
        }
    }

    public double getCapacidadBls() {
        return this.capacidadBls;
    }

    public void setNivelActualBls(double nivelActualBls) {
        if (nivelActualBls >= 0 && nivelActualBls <= this.capacidadBls) {
            this.nivelActualBls = nivelActualBls;
        } else {
            System.out.println("Error en: "  + this.nombre + " El nivel debe estar entre 0 y " + this.capacidadBls + " Bls");
        }
    }

    public double getNivelActualBls() {
        return this.nivelActualBls;
    }

    public void mostrarInfo() {
        System.out.println(
                "Tanque: " + nombre + " | capacidadBls: " + capacidadBls + " | nivelActualBls: " + nivelActualBls);

    }

    public double calcularPorcentajeLleno() {
        return ((nivelActualBls / capacidadBls) * 100);

    }

}
