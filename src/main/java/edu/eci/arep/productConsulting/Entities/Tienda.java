package edu.eci.arep.productConsulting.Entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tienda{
    @Id
    private String nombre;
    private List<Producto> productos;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Tienda() {
    }

    public Tienda(String nombre, List<Producto> productos) {
      
        this.nombre = nombre;
        this.productos = productos;
    }
    
}