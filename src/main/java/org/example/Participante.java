package org.example;

import java.util.Objects;

public class Participante {
    private static int contadorId = 1;
    private int idParticipante;
    private String nombre;
    private String apellido;
    private String email;
    private int puntos;

    public Participante(String nombre, String apellido, String email) {
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        if (apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("El email no es válido");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.idParticipante = contadorId++;
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

    public String getEmail() {
        return email;
    }
}
