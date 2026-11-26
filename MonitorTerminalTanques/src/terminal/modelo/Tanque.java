package terminal.modelo;

public class Tanque {
    private String nombre;
    private double capacidadBls;
    private double nivelActualBls;

    public Tanque(String nombre, double capacidadBls, double nivelActualBls) {
        setNombre(nombre);
        setCapacidadBls(capacidadBls);
        setNivelActualBls(nivelActualBls);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío o nulo.");

        }
        if (!nombre.matches("TK \\d{3}")) {
            throw new IllegalArgumentException("El formato de nombre debe ser TK 000: " + nombre);
        }

        this.nombre = nombre;
    }

    public double getCapacidadBls() {
        return this.capacidadBls;
    }

    public void setCapacidadBls(double capacidadBls) {
        if (capacidadBls <= 0) {
            throw new IllegalArgumentException("Error en: " + this.nombre + " La capacidad debe ser mayor a cero: "+ capacidadBls);
        }

        this.capacidadBls = capacidadBls;
    }

    public double getNivelActualBls() {
        return this.nivelActualBls;
    }

    public void setNivelActualBls(double nivelActualBls) {
        if (nivelActualBls >= 0 && nivelActualBls <= this.capacidadBls) {
            this.nivelActualBls = nivelActualBls;
        } else {
            System.out.println(
                    "Error en: " + this.nombre + " El nivel debe estar entre 0 y " + this.capacidadBls + " Bls");
        }
    }

    public void mostrarInfo() {
        System.out.println(
                "Tanque: " + nombre + " | capacidadBls: " + capacidadBls + " | nivelActualBls: " + nivelActualBls);

    }

    public double calcularPorcentajeLleno() {
        if (capacidadBls <= 0) {
            System.out.println("Error en: " + this.nombre + " ...");
            return (0);
        } else {
            return (nivelActualBls / capacidadBls) * 100;
        }
    }

}
