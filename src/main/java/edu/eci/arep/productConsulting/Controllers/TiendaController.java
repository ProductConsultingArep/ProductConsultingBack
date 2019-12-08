package edu.eci.arep.productConsulting.Controllers;

import edu.eci.arep.productConsulting.Entities.Tienda;
import edu.eci.arep.productConsulting.Repository.TiendaRepository;

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
public class TiendaController{
    @Autowired
    private TiendaRepository TiendaRepository;

    @RequestMapping(value="/Tienda",method=RequestMethod.GET)
    public ResponseEntity<?> Tiendas(){
        try {
	        return new ResponseEntity<>(TiendaRepository.findAll(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(value="/Tienda/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> TiendaById(@PathVariable("id") String TiendaId){
        try {
	        return new ResponseEntity<>(TiendaRepository.findById(TiendaId),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(value="/Tienda",method=RequestMethod.POST)
    public ResponseEntity<?> postTienda(@RequestBody Tienda t){
        try {
			TiendaRepository.insert(t);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}
    }

    @RequestMapping(value="/Tienda",method=RequestMethod.PUT)
    public ResponseEntity<?> updateTienda(@RequestBody Tienda t){
        try {
			TiendaRepository.save(t);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }
    @RequestMapping(value="/Tienda/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteTienda(@PathVariable("id") String TiendaId){
        try {
			TiendaRepository.deleteById(TiendaId);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }
}
