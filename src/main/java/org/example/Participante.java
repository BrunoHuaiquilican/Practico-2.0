package org.example;

import java.util.Objects;

public class Participante {
    private static int contadorId = 1; // Contador estático para asignar id únicos
    private int idParticipante;
    private String nombre;
    private String apellido;
    private int puntos;

    public Participante(String nombre, String apellido) {
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.idParticipante = contadorId++; // Asigna un id único a cada participante
    }

    public void cargarPuntos(int puntos){
        this.puntos += puntos;
    }
    public int getIdParticipante(){
        return idParticipante;
    }
    public String getNombre() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Participante that = (Participante) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }

    public int puntos() {
        return puntos;
    }

}
