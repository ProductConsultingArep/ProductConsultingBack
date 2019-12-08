package edu.eci.arep.productConsulting.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Orden{
    @Id
    private String id;
    private String idProducto;
    private int cantidad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
    