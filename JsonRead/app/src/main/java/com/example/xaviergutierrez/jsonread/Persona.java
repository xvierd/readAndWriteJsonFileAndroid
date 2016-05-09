package com.example.xaviergutierrez.jsonread;

/**
 * Created by xaviergutierrez on 30/1/16.
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String tlf;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String tlf) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tlf = tlf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", tlf='" + tlf + '\'' +
                '}';
    }
}
