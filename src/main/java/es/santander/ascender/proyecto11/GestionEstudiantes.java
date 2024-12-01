package es.santander.ascender.proyecto11;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GestionEstudiantes implements IGestionEstudiantes {
    private Map<String, Integer> estudiantes;

    public GestionEstudiantes() {
        this.estudiantes = new HashMap<>();
    }

    @Override
    public boolean agregarEstudiante(String nombre, int calificacion) {
        if (nombre == null) {
            return false;
        }
        if (nombre.trim().isEmpty()) {
            return false;
        }
        if( nombre.isEmpty()){
            return false;
        }
        if (!nombre.matches("^[a-zA-Z ]+$")) {
            return false; 
        }
        if(calificacion < 0){
            return false; 
        }
        if(calificacion > 100){
            return false;
        }
        if(estudiantes.containsKey(nombre)){
            return false;
        }
        estudiantes.put(nombre, calificacion);
        return true;
    }

    @Override
    public Integer obtenerCalificacion(String nombre) {
        return estudiantes.get(nombre);
    }

    @Override
    public Map<String, Integer> obtenerEstudiantesYCalificaciones() {
        return new HashMap<>(estudiantes); // Devuelve una copia
    }

    @Override
    public boolean existeEstudiante(String nombre) {
        return estudiantes.containsKey(nombre);
    }

    @Override
    public boolean eliminarEstudiante(String nombre) {
        if (estudiantes.containsKey(nombre)) {
            estudiantes.remove(nombre);
            return true;
        }
        return false;
    }

    @Override
    public void agregarEstudiantes(Set<String> nuevosEstudiantes, Map<String, Integer> nuevasCalificaciones) {
        if (nuevosEstudiantes != null && nuevasCalificaciones != null) {
            for (String nombreEstudiante : nuevosEstudiantes) {
                if (nuevasCalificaciones.containsKey(nombreEstudiante)) {
                    int calificacion = nuevasCalificaciones.get(nombreEstudiante);
                    if (!estudiantes.containsKey(nombreEstudiante) && calificacion >= 0 && calificacion <= 100) {
                        estudiantes.put(nombreEstudiante, calificacion);
                    }
                }
            }
        }
    }
}

