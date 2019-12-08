package edu.eci.arep.productConsulting.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.arep.productConsulting.Entities.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {
    
}