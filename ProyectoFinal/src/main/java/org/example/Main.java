package org.example;

import org.example.controlador.ControladorXMen;
import org.example.datos.XMENDAO;
import org.example.vista.VentanaXMEN;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaXMEN view = new VentanaXMEN("XMEN");
        ControladorXMen controller = new ControladorXMen(view);



    }
}