package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class XMEN {
    private Integer id;
    private String personaje;
    private String actor;
    private String poder;
    private String pelicula;
    private String url;

    public XMEN() {
    }

    public XMEN(Integer id, String personaje, String actor, String poder, String pelicula, String url) {
        this.id = id;
        this.personaje = personaje;
        this.actor = actor;
        this.poder = poder;
        this.pelicula = pelicula;
        this.url = url;
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getPoder() {
        return poder;
    }

    public void setPoder(String poder) {
        this.poder = poder;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "XMEN{" +
                "id=" + id +
                ", personaje='" + personaje + '\'' +
                ", actor='" + actor + '\'' +
                ", poder='" + poder + '\'' +
                ", pelicula='" + pelicula + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public ImageIcon getImagen()throws MalformedURLException {
        URL urlImagen = new URL(this.url);
        return new ImageIcon(urlImagen);
    }
}
