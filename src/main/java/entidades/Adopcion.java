package entidades;

public class Adopcion {
    private Adoptante adoptante;
    private Mascota masctota;
    private Empleado empleado;

    public Adopcion(Adoptante adoptante, Mascota mascota, Empleado empleado){
        this.adoptante = adoptante;
        this.masctota = mascota;
        this.empleado = empleado;
    }
}
