package edu.eci.arep.productConsulting.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.arep.productConsulting.Entities.Orden;;

public interface OrdenRepository extends MongoRepository<Orden, String> {
    
}