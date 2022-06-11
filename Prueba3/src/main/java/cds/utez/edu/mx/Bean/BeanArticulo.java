package cds.utez.edu.mx.Bean;

public class BeanArticulo {
    int idArticulo;
    String nombreArt;
    String descripcionArt;
    int cantidad;
    double precio;
    BeanCategoria categoria;

    public BeanArticulo() {
    }

    public BeanArticulo(int idArticulo, String nombreArt, String descripcionArt, int cantidad, double precio, BeanCategoria categoria) {
        this.idArticulo = idArticulo;
        this.nombreArt = nombreArt;
        this.descripcionArt = descripcionArt;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public String getDescripcionArt() {
        return descripcionArt;
    }

    public void setDescripcionArt(String descripcionArt) {
        this.descripcionArt = descripcionArt;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public BeanCategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(BeanCategoria categoria) {
        this.categoria = categoria;
    }
}
