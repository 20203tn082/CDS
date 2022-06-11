package cds.utez.edu.mx.Dao;


import cds.utez.edu.mx.Bean.BeanCategoria;
import cds.utez.edu.mx.Connection.ConnectionMySQL;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCategoria {
    static Connection con;
    static CallableStatement cstm;
    static ResultSet rs;

    //Regresar todas las categorías
    public static List<BeanCategoria> getAll() {
        List<BeanCategoria> categorias = new ArrayList<>();
        try {
            //obtener la conexión para trabajar con ella
            con = ConnectionMySQL.getConnection();
            //llamo los metodos de la base de datos
            cstm = con.prepareCall("SELECT * FROM categoria");
            //executeQuery es para consultas
            rs = cstm.executeQuery();
            while (rs.next()) {
                //BeanCategoria categoria = new BeanCategoria();
                //categoria.setIdCategoria(rs.getInt("idCategoria"));
                //categoria.setNombrCat(rs.getString("nombreCat"));
                //categoria.setDescripcionCat(rs.getString("descripcionCat"));

                BeanCategoria categoria = new BeanCategoria(rs.getInt("idCat"),
                        rs.getString("nombreCat"), rs.getString("descripcionCat"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error en el método getAll " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return categorias;
    }


    //obtener una sola categoría
    public static BeanCategoria getCategoria(int id){
        BeanCategoria categoria = new BeanCategoria();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM categoria WHERE idCat = ? ");
            //enviar el id que recibí
            cstm.setInt(1, id);
            rs = cstm.executeQuery();
            if (rs.next()){
                categoria = new BeanCategoria(
                        rs.getInt("idCat"),
                        rs.getString("nombreCat"),
                        rs.getString("descripcionCat")
                );
            }else{
                System.out.println("No se encontró la categoría");
                categoria = null;
            }
        }catch (SQLException e){
            System.out.println("Ha ocurrido un error en el método getCategoria " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con,cstm,rs);
        }
        return categoria;
    }

    //REGISTRAR CATEGORÍA
    public static boolean isRegistrado(BeanCategoria categoria){
        boolean registrada = false;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("INSERT INTO  categoria(nombreCat, descripcionCat) VALUES (?,?)");
            cstm.setString(1, categoria.getNombrCat());
            cstm.setString(2, categoria.getDescripcionCat());
            registrada = !cstm.execute();
        }catch (SQLException e){
            System.out.println("Ha ocurrido un error en el  método isRegistrado: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con,cstm);
        }
        return registrada;
    }

    //ACTUALIZAR CATEGORÍA
    public static boolean isActualizado(BeanCategoria categoria){
        boolean actualizada = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("UPDATE categoria SET nombreCat = ?, descripcionCat = ? WHERE idCat = ?");
            cstm.setString(1, categoria.getNombrCat());
            cstm.setString(2, categoria.getDescripcionCat());
            cstm.setInt(3, categoria.getIdCategoria());
            actualizada = !cstm.execute();
        }catch (SQLException e){
            System.out.println("Ha ocurrido un error en el método isActualizado: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return actualizada;
    }

    //ELIMINAR CATEGORÍA
    public static boolean isEliminado(BeanCategoria categoria){
        boolean eliminada = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("DELETE FROM categoria WHERE idCat = ? ");
            cstm.setInt(1, categoria.getIdCategoria());
            eliminada = !cstm.execute();
        }catch (SQLException e){
            System.out.println("Ha ocurrido un error en el método isEliminado: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return eliminada;
    }


    public static void main(String[] args) {

        //PARA CONSULTA GENERAL
        //List<BeanCategoria> datos = getAll();
        //for (BeanCategoria categoria : datos) {
            //System.out.println("Id: " + categoria.getIdCategoria());
            //System.out.println("Nombre categoría: " + categoria.getNombrCat());
            //System.out.println("Descripción categoría: " + categoria.getDescripcionCat());
        //}

        //PARA CONSULTA ESPECÍFICA
        //BeanCategoria categoria = getCategoria(1);
        //System.out.println("Id de la categoría: " + categoria.getIdCategoria());
        //System.out.println("Nombre de la categoría: " + categoria.getNombrCat());
        //System.out.println("Descripción de la categoría: " + categoria.getDescripcionCat());

        //PARA REGISTRAR
        //BeanCategoria categoria = new BeanCategoria(0,"Lactéos","De origen animal");
        //boolean registrar = isRegistrado(categoria);
        //if (registrar) System.out.println("Se ha registrado correctamente la categoría");
        //else System.out.println("No se pudo registrar la categoría");

        //PARA ACTUALIZAR
        //BeanCategoria categoria = new BeanCategoria(1,"Comida", "All alimento que se puede comer");
        //boolean actualizar = isActualizado(categoria);
        //if (actualizar) System.out.println("Se ha actualizado correctamente la categoría");
        //else System.out.println("No se pudo actualizar la categoría");

        //PARA ELIMINAR
        //BeanCategoria categoria = new BeanCategoria(2, "", "");
        //boolean eliminar = isEliminado(categoria);
        //if (eliminar) System.out.println("Categoría eliminada exitosamente");
        //else System.out.println("No se pudo eliminar la categoría");
    }

}
