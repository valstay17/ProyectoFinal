package org.example.modelo;
import org.example.datos.ConexionDatos;
import org.example.datos.XMENDAO;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaXMEN implements TableModel {
    private ArrayList<XMEN> datos;
    public static final int COLS = 6;
    private XMENDAO ldao;
    public ModeloTablaXMEN(){
        datos = new ArrayList<>();
        ldao = new XMENDAO();
    }
    public ModeloTablaXMEN(ArrayList<XMEN> datos){
        this.datos = datos;
    }
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombreCol = "";
        switch (columnIndex){
            case 0:
                nombreCol = "ID";
                break;
            case 1:
                nombreCol = "Personaje";
                break;
            case 2:
                nombreCol = "Actor";
                break;
            case 3:
                nombreCol = "Poder";
                break;
            case 4:
                nombreCol = "Pelicula";
                break;
            case 5:
                nombreCol = "Imagen";
                break;
            default:
                nombreCol = "";
        }
        return nombreCol;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return Short.class;
            case 3:
                return String.class;
            case 4:
                return Short.class;
            case 5:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        XMEN tmp = datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getPersonaje();
            case 2:
                return tmp.getActor();
            case 3:
                return tmp.getPoder();
            case 4:
                return tmp.getPelicula();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                datos.get(rowIndex).setId((Integer) aValue);
                break;
            case 1:
                datos.get(rowIndex).setPersonaje((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setActor((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setPoder((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setPelicula((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {


    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }

    public boolean agregarXMEN (XMEN xmen){
        boolean resultado = false;
        try{
            if(ldao.insertar(xmen)){
                datos.add(xmen);
                resultado = true;
            }else {
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
   public void cargarDatos(){
       try {
          ArrayList<XMEN> tirar = ldao.obtenerTodo();
            System.out.println(tirar);
            datos = ldao.obtenerTodo();
       }catch (SQLException sqle){
           System.out.println(sqle.getMessage());
       }
    }


    public XMEN getXMENAtIndex(int idx){
        return datos.get(idx);
    }

    public boolean actualizarXMEN (XMEN xmen){
        try {
            return ldao.update(xmen);
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
            return true;
        }
    }
    public boolean actualizarElemento(String datoActualizado, int id, int colIndex) throws SQLException{
        if(ldao.updateElement(datoActualizado, id, colIndex)){
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarXMEN(String id){
        try {
            String sqlDelete = "DELETE FROM xmen WHERE id = ?;";
            int rowCount = 0;
            PreparedStatement pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlDelete);
            pstm.setInt(1,Integer.parseInt(id));
            rowCount = pstm.executeUpdate();

            return rowCount >0;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return false;

        }
    }


}
