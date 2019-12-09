package edu.eci.arep.productConsulting.Entities;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Tienda{
    //@Id
    private String id = new ObjectId().toString();
    @Id
    private String nombre;
    private String direccion;
    private Long telefono;
    private List<Producto> productos = new ArrayList<>();

    public Tienda() {
    }

    public Tienda(String nombre, List<Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public Tienda(String nombre, String direccion, Long telefono){
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

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

    public String getDireccion(){
        return this.direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public Long getTelefono(){
        return this.telefono;
    }

    public void setTelefono(Long telefono){
        this.telefono = telefono;
    }

    public String getId(){
        return this.id;
    }

}