package com.example.dm2.fragments;

import java.io.Serializable;

public class Juego implements Serializable {
    private String nombre, tipo, precio;

    public Juego(String nombre, String tipo, String precio) {
        this.nombre = nombre;
        this.tipo=tipo;
        this.precio=precio;

    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPrecio() {
        return precio;
    }

}
