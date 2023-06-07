package org.example.controlador;

import org.example.modelo.ModeloTablaXMEN;
import org.example.modelo.XMEN;
import org.example.vista.VentanaXMEN;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.sql.SQLException;

public class ControladorXMen extends MouseAdapter {
    private VentanaXMEN view;
    private ModeloTablaXMEN modelo;

    private int filaSeleccionada;
    private int columnaSeleccionada;

    public ControladorXMen(VentanaXMEN view) {
        this.view = view;
        this.view.getBotonAdd().addMouseListener(this);
        this.view.getTabla().addMouseListener(this);
        this.view.getBotonCargar().addMouseListener(this);
        this.view.getBotonActualizar().addMouseListener(this);
        this.view.getBotonEliminar().addMouseListener(this);
        modelo = new ModeloTablaXMEN();
        this.view.getTabla().setModel(modelo);




    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBotonCargar()){
            modelo.cargarDatos();
            this.view.getTabla().setModel(modelo);
            this.view.getTabla().updateUI();
        }
        if(e.getSource() == this.view.getBotonEliminar()){
            int index = this.view.getTabla().getSelectedRow();
            int id = modelo.getXMENAtIndex(index).getId();
            int respuesta = JOptionPane.showConfirmDialog(view, "¿Desea eliminar la fila seleccionada?", "Cuidado", JOptionPane.YES_NO_OPTION);
            if(respuesta == 0){
                if(modelo.eliminarXMEN(String.valueOf(id))){
                    JOptionPane.showMessageDialog(view, "Se elimino");
                    modelo.cargarDatos();
                    this.view.getTabla().setModel(modelo);
                    this.view.getTabla().updateUI();
                }
            }
            System.out.println("Eliminar...");
        }
        if(e.getSource() == this.view.getBotonActualizar()){
            int index = this.view.getTabla().getSelectedRow();
            XMEN tmp = modelo.getXMENAtIndex(index);
            int id = tmp.getId();
            String datoActualizado = JOptionPane.showInputDialog(view, "Introduce el dato a actualizar" + this.view.getTabla().getColumnName(view.getTabla().getSelectedColumn())+ "del registro"+id, "UPDATE", JOptionPane.INFORMATION_MESSAGE);
            int colIndex = this.view.getTabla().getSelectedColumn();

            try{
                if(modelo.actualizarElemento(datoActualizado, id, colIndex)){
                    System.out.println("Se actualizo");
                    modelo.cargarDatos();
                    this.view.getTabla().setModel(modelo);
                    this.view.getTabla().updateUI();
                }else{
                    System.out.println("Fallo actualizar el dato");
                }
            }catch (SQLException sqle){
                throw new RuntimeException(sqle);
            }

        }

        if(e.getSource() == view.getBotonAdd()){
            System.out.println("Evento sobre boton add");
            XMEN xmen = new XMEN();
            xmen.setId(0);
            xmen.setPersonaje(this.view.getTxtPersonaje().getText());
            xmen.setActor(this.view.getTxtActor().getText());
            xmen.setPoder(this.view.getTxtPoder().getText());
            xmen.setPelicula(this.view.getTxtPelicula().getText());
            xmen.setUrl(this.view.getTxtImagen().getText());
            modelo.agregarXMEN(xmen);

            this.view.getTabla().updateUI();
        }
        if(e.getSource() == view.getTabla()){
            System.out.println("Evento sobre tabla");
            int index = this.view.getTabla().getSelectedRow();
            XMEN tmp = modelo.getXMENAtIndex(index);

            try{
                this.view.getImagenXMEN().setIcon(tmp.getImagen());
                this.view.getImagenXMEN().setText("");
            }catch (MalformedURLException mfue){
                System.out.println(e.toString());

            }

        }

    }
}
