package edu.eci.arep.productConsulting.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.arep.productConsulting.Entities.Pedido;;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
    
}