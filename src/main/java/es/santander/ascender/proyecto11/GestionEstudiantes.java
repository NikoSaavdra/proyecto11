package es.santander.ascender.proyecto11;

public class GestionEstudiantes {

    private String nombre;
    private int calificacion;

    public GestionEstudiantes(String nombre, int calificacion){
        this.nombre = nombre;
        this.calificacion = calificacion;
    }
    
    public int getCalificacion() {
        return calificacion;
    }
    public String getNombre() {
        return nombre;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean agregarEstudiante(String nombre, int calificacion){
        
        return ;
    }
}
