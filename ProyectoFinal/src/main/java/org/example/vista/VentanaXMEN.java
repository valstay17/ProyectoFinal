package org.example.vista;

import org.example.datos.ConexionDatos;

import javax.swing.*;
import java.awt.*;

public class VentanaXMEN extends JFrame {
    private JLabel lblId;
    private JLabel lblPersonaje;
    private JLabel lblActor;
    private JLabel lblPoder;
    private JLabel lblPelicula;
    private JLabel lblImagen;
    private JTextField txtId;
    private JTextField txtPersonaje;
    private JTextField txtActor;
    private JTextField txtPoder;
    private JTextField txtPelicula;
    private JTextField txtImagen;
    private JButton botonAdd;
    private JButton botonCargar;
    private JButton botonEliminar;
    private JButton botonActualizar;
    private JLabel imagenXMEN;

    private JTable tabla;
    private GridLayout layout;
    private JScrollPane scroll;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;


    private JLabel lblActualizar;
    private JTextField txtActualizar;

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblPersonaje() {
        return lblPersonaje;
    }

    public void setLblPersonaje(JLabel lblPersonaje) {
        this.lblPersonaje = lblPersonaje;
    }

    public JLabel getLblActor() {
        return lblActor;
    }

    public void setLblActor(JLabel lblActor) {
        this.lblActor = lblActor;
    }

    public JLabel getLblPoder() {
        return lblPoder;
    }

    public void setLblPoder(JLabel lblPoder) {
        this.lblPoder = lblPoder;
    }

    public JLabel getLblPelicula() {
        return lblPelicula;
    }

    public void setLblPelicula(JLabel lblPelicula) {
        this.lblPelicula = lblPelicula;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtPersonaje() {
        return txtPersonaje;
    }

    public void setTxtPersonaje(JTextField txtPersonaje) {
        this.txtPersonaje = txtPersonaje;
    }

    public JTextField getTxtActor() {
        return txtActor;
    }

    public void setTxtActor(JTextField txtActor) {
        this.txtActor = txtActor;
    }

    public JTextField getTxtPoder() {
        return txtPoder;
    }

    public void setTxtPoder(JTextField txtPoder) {
        this.txtPoder = txtPoder;
    }

    public JTextField getTxtPelicula() {
        return txtPelicula;
    }

    public void setTxtPelicula(JTextField txtPelicula) {
        this.txtPelicula = txtPelicula;
    }

    public JTextField getTxtImagen() {
        return txtImagen;
    }

    public void setTxtImagen(JTextField txtImagen) {
        this.txtImagen = txtImagen;
    }

    public JButton getBotonAdd() {
        return botonAdd;
    }

    public void setBotonAdd(JButton botonAdd) {
        this.botonAdd = botonAdd;
    }

    public JButton getBotonCargar() {
        return botonCargar;
    }

    public void setBotonCargar(JButton botonCargar) {
        this.botonCargar = botonCargar;
    }

    public JButton getBotonEliminar() {
        return botonEliminar;
    }

    public void setBotonEliminar(JButton botonEliminar) {
        this.botonEliminar = botonEliminar;
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }

    public void setBotonActualizar(JButton botonActualizar) {
        this.botonActualizar = botonActualizar;
    }

    public JLabel getImagenXMEN() {
        return imagenXMEN;
    }

    public void setImagenXMEN(JLabel imagenXMEN) {
        this.imagenXMEN = imagenXMEN;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getLblActualizar() {
        return lblActualizar;
    }

    public void setLblActualizar(JLabel lblActualizar) {
        this.lblActualizar = lblActualizar;
    }

    public JTextField getTxtActualizar() {
        return txtActualizar;
    }

    public void setTxtActualizar(JTextField txtActualizar) {
        this.txtActualizar = txtActualizar;
    }
    public void limpiar(){
        txtPersonaje.setText("");
        txtActor.setText("");
        txtPoder.setText("");
        txtPelicula.setText("");
        txtImagen.setText("");
    }

    public VentanaXMEN(String title) throws HeadlessException {
        super(title);
        this.setSize(950,900);
        layout = new GridLayout(2,2 );
        this.getContentPane().setLayout(layout);

        //panel 1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(180, 229, 160));
        lblId = new JLabel("ID:");
        lblPersonaje = new JLabel("Personaje:");
        lblActor = new JLabel("Actor:");
        lblPoder = new JLabel("Poder:");
        lblPelicula = new JLabel("Pelicula:");
        lblImagen = new JLabel("Imagen:");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtPersonaje = new JTextField(15);
        txtActor = new JTextField(15);
        txtPoder = new JTextField(15);
        txtPelicula = new JTextField(15);
        txtImagen = new JTextField(30);
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblPersonaje);
        panel1.add(txtPersonaje);
        panel1.add(lblActor);
        panel1.add(txtActor);
        panel1.add(lblPoder);
        panel1.add(txtPoder);
        panel1.add(lblPelicula);
        panel1.add(txtPelicula);
        panel1.add(lblImagen);
        panel1.add(txtImagen);
        botonAdd = new JButton("Agregar");
        panel1.add(botonAdd);

        //panel 2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(253, 204, 204));
        botonCargar = new JButton("Cargar datos");
        panel2.add(botonCargar);
        tabla = new JTable();
        scroll = new JScrollPane(tabla);
        panel2.add(scroll);


        //panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(249, 255, 170));
        imagenXMEN = new JLabel("XMEN");
        panel3.add(imagenXMEN);


        //panel 4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(248, 148, 148));
        panel4.setLayout(new FlowLayout());
        botonEliminar = new JButton("Eliminate");
        panel4.add(botonEliminar);
        botonActualizar = new JButton("UPDATE");
        panel4.add(botonActualizar);



        this.getContentPane().add(panel1,0);
        this.getContentPane().add(panel2,1);
        this.getContentPane().add(panel3,2);
        this.getContentPane().add(panel4,3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);



    }
}
