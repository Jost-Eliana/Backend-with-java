package modelo;

public class Odontologo {
    private int id;
    private int numeroDeMatricula;
    private String nombre;
    private String apellido;

    public Odontologo(int numeroDeMatricula, String string, String nombre, String apellido) {
        this.numeroDeMatricula = numeroDeMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Odontologo(int ID, int numeroDeMatricula, String nombre, String apellido) {
        this.id = ID;
        this.numeroDeMatricula = numeroDeMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public int getNumeroDeMatricula() {
        return numeroDeMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "numeroDeMatricula=" + numeroDeMatricula +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
