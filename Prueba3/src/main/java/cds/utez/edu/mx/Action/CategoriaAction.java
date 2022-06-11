package cds.utez.edu.mx.Action;

import cds.utez.edu.mx.Bean.BeanCategoria;
import cds.utez.edu.mx.Dao.DaoCategoria;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriaAction extends ActionSupport {
    //Variable para recibir los datos del front
    private String datos;
    //Envia mensajes de vuelta al front, después de realizar las operaciones
    private Map<String, Object> mensaje = new HashMap<>();
    //Variable que va a recibir las lista de la consulta general
    private List<BeanCategoria> listaConsulta = new ArrayList<>();
    //variable que reciba la consulta especifica
    private BeanCategoria consultaEspecifica = new BeanCategoria();
    private BeanCategoria categoriaRegistrar = new BeanCategoria();
    private BeanCategoria categoriaActualizar = new BeanCategoria();
    private BeanCategoria categoriaEliminar = new BeanCategoria();
    //Transformar los datos a Gson nativo de Java
    private Gson gs = new Gson();

    //CONSULTA GENERAL
    //REGRESAR SUCCESS O ERROR
    public String consultaGeneral(){
        System.out.println("Holi desde action");
        try {
            //Ya tengo todas las categorías
            listaConsulta = DaoCategoria.getAll();
            //Se crea el objeto de respuesta
            //          key, objeto
            mensaje.put("data", listaConsulta);
            return SUCCESS;
        }catch (Exception e){
            return ERROR;
        }
    }

    public String consultaEspecifica(){
        try{
            //Transformar la categoría enviada por el front a un objeto de JAVA
            consultaEspecifica = gs.fromJson(datos, BeanCategoria.class);
            //Ejecución del método getCategooria
            BeanCategoria categoria = DaoCategoria.getCategoria(consultaEspecifica.getIdCategoria());
            //Se agrega al objeto los datos
            mensaje.put("data", categoria);
            return SUCCESS;
        }catch (Exception e){
            return ERROR;
        }
    }

    public String registrar(){
        try{
            categoriaRegistrar = gs.fromJson(datos, BeanCategoria.class);
            boolean registrada = DaoCategoria.isRegistrado(categoriaRegistrar);
            mensaje.put("registrada",registrada);
            //mensaje:{
            //      registrada: el valor que regresa registrada (true/false)
            //}
            return SUCCESS;
        }catch (Exception e){
            return ERROR;
        }
    }

    public String actualizar(){
        try {
            categoriaActualizar = gs.fromJson(datos, BeanCategoria.class);
            boolean actualizada = DaoCategoria.isActualizado(categoriaActualizar);
            mensaje.put("actualizada", actualizada);
            return SUCCESS;
        }catch (Exception e){
            return ERROR;
        }
    }

    public String eliminar(){
        try {
            categoriaEliminar = gs.fromJson(datos, BeanCategoria.class);
            boolean eliminada = DaoCategoria.isEliminado(categoriaEliminar);
            mensaje.put("eliminada", eliminada);
            return SUCCESS;
        }catch (Exception e){
            return ERROR;
        }
    }

    //set para enviar
    //get para recibir


    public Map<String, Object> getMensaje() {
        return mensaje;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}
