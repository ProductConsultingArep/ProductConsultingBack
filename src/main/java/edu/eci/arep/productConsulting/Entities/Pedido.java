package edu.eci.arep.productConsulting.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pedido{
    @Id
    private String id = new ObjectId().toString();
    private Tienda tienda;
    private List<Orden> ordenes;
    private String estado;
    private String descripcion;

    private Date fecha = new Date();

    public Pedido() {
    }



    public Pedido(Tienda tienda, List<Orden> ordenes, String estado) {
        this.tienda = tienda;
        this.estado=estado;
        this.ordenes = ordenes;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Orden> getOrdenes() {
        return ordenes;
    }
    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(String idTienda) {
        this.tienda = tienda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Date getFecha(){
        return fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

}