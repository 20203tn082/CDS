package cds.utez.edu.mx.Bean;

public class BeanCategoria {
    private int idCategoria;
    private String nombrCat;
    private String descripcionCat;

    public BeanCategoria() {
    }

    public BeanCategoria(int idCategoria, String nombrCat, String descripcionCat) {
        this.idCategoria = idCategoria;
        this.nombrCat = nombrCat;
        this.descripcionCat = descripcionCat;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombrCat() {
        return nombrCat;
    }

    public void setNombrCat(String nombrCat) {
        this.nombrCat = nombrCat;
    }

    public String getDescripcionCat() {
        return descripcionCat;
    }

    public void setDescripcionCat(String descripcionCat) {
        this.descripcionCat = descripcionCat;
    }
}
