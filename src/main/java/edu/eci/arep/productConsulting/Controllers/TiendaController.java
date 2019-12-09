package edu.eci.arep.productConsulting.Controllers;

import edu.eci.arep.productConsulting.Entities.Tienda;
import edu.eci.arep.productConsulting.Repository.TiendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;


@RestController
@CrossOrigin
@RequestMapping("/tiendas")
public class TiendaController{
    @Autowired
    private TiendaRepository TiendaRepository;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<?> Tiendas(){
        try {
	        return new ResponseEntity<>(TiendaRepository.findAll(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> postTienda(@RequestBody Tienda t){
		try {
			System.out.println(t);
			TiendaRepository.insert(t);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
	}

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> TiendaById(@PathVariable("id") String TiendaId){
        try {
	        return new ResponseEntity<>(TiendaRepository.findById(TiendaId),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<?> updateTienda(@RequestBody Tienda t){
        try {
			TiendaRepository.save(t);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteTienda(@PathVariable("id") String TiendaId){
        try {
			TiendaRepository.deleteById(TiendaId);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping(value="/deleteAll")
	public ResponseEntity<?> deleteTiendas(){
		TiendaRepository.deleteAll();
    	return new ResponseEntity<>(HttpStatus.OK);
	}
}
