package org.example.datos;

import org.example.modelo.XMEN;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class XMENDAO implements InterfazDAO{
    public XMENDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO xmen(PERSONAJE, ACTOR, PODER, PELICULA, URL) VALUES(?,?,?,?,?)";
        int rowCount = 0;

            PreparedStatement pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlInsert);
            pstm.setString(1,((XMEN)obj).getPersonaje());
            pstm.setString(2,((XMEN)obj).getActor());
            pstm.setString(3,((XMEN)obj).getPoder());
            pstm.setString(4,((XMEN)obj).getPelicula());
            pstm.setString(5,((XMEN)obj).getUrl());
            rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE xmen SET personaje = ?, actor = ?, poder = ?, pelicula = ?, url = ? WHERE id = ? ;";
        int rowCount = 0;

        PreparedStatement pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1,((XMEN)obj).getPersonaje());
        pstm.setString(2,((XMEN)obj).getActor());
        pstm.setString(3,((XMEN)obj).getPoder());
        pstm.setString(4,((XMEN)obj).getPelicula());
        pstm.setString(5,((XMEN)obj).getUrl());
        pstm.setInt(6, ((XMEN)obj).getId());
        rowCount = pstm.executeUpdate();

        return rowCount >0;
    }
    //metodo para actualizar solo un elemento
    public boolean updateElement(String datoActualizado, int id, int colIndex) throws SQLException{
        String sqlUpdate;
        PreparedStatement pstm;
        int rowCount;
        switch (colIndex){
            case 1:
                sqlUpdate = "UPDATE xmen SET personaje = ? Where id = ? ;";
                rowCount = 0;
                pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                rowCount = pstm.executeUpdate();
                return rowCount > 0;
            case 2:
                sqlUpdate = "UPDATE xmen SET actor = ? Where id = ? ;";
                rowCount = 0;
                pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                rowCount = pstm.executeUpdate();
                return rowCount > 0;
            case 3:
                sqlUpdate = "UPDATE xmen SET poder = ? Where id = ? ;";
                rowCount = 0;
                pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                rowCount = pstm.executeUpdate();
                return rowCount > 0;
            case 4:
                sqlUpdate = "UPDATE xmen SET pelicula = ? Where id = ? ;";
                rowCount = 0;
                pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                pstm.setInt(2,id);
                rowCount = pstm.executeUpdate();
                return rowCount > 0;
            case 5:
                sqlUpdate = "UPDATE xmen SET url = ? Where id = ? ;";
                rowCount = 0;
                pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1,(datoActualizado));
                rowCount = pstm.executeUpdate();
                return rowCount > 0;

        }
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM xmen WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount >0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM xmen";
        ArrayList<XMEN> resultado = new ArrayList<>();
        Statement stm = ConexionDatos.getInstance("xmen.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new XMEN(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sqlID = "SELECT * FROM xmen WHERE id = ? ;";
        XMEN xmen = null;
            PreparedStatement pstm = ConexionDatos.getInstance("xmen.db").getConnection().prepareStatement(sqlID);
            pstm.setInt(1, Integer.parseInt(id));
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                xmen = new XMEN(rst.getInt(1),rst.getString(2), rst.getString(3),rst.getString(4),rst.getString(5),rst.getString(6));
                return xmen;
            }
            return null;
    }
}
