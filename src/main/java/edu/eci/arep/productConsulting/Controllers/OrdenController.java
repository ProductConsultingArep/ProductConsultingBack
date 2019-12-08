package edu.eci.arep.productConsulting.Controllers;

import edu.eci.arep.productConsulting.Entities.Orden;
import edu.eci.arep.productConsulting.Repository.OrdenRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class OrdenController{
    @Autowired
    private OrdenRepository ordenRepository;

    @RequestMapping(value="/orden",method=RequestMethod.GET)
    public ResponseEntity<?> ordenes(){
        try {
	        return new ResponseEntity<>(ordenRepository.findAll(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(value="/orden/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> OrdenById(@PathVariable("id") String ordenId){
        try {
	        return new ResponseEntity<>(ordenRepository.findById(ordenId),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(value="/orden",method=RequestMethod.POST)
    public ResponseEntity<?> postOrden(@RequestBody Orden o){
        try {
			ordenRepository.insert(o);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}
    }

    @RequestMapping(value="/orden",method=RequestMethod.PUT)
    public ResponseEntity<?> updateOrden(@RequestBody Orden o){
        try {
			ordenRepository.save(o);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }
    @RequestMapping(value="/orden/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteOrden(@PathVariable("id") String ordenId){
        try {
			ordenRepository.deleteById(ordenId);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }
}
