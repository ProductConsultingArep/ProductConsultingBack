package edu.eci.arep.productConsulting.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.arep.productConsulting.Entities.Tienda;

public interface TiendaRepository extends MongoRepository<Tienda, String> {
    
}