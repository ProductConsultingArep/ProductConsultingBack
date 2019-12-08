package edu.eci.arep.productConsulting.Entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Pedido{
    @Id
    private String id;
    private String idTienda;
    private List<Orden> ordenes;

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

    public Pedido() {
    }

    public String getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(String idTienda) {
        this.idTienda = idTienda;
    }

    public Pedido(String id, String idTienda, List<Orden> ordenes) {
        this.id = id;
        this.idTienda = idTienda;
        this.ordenes = ordenes;
    }
    
    
}