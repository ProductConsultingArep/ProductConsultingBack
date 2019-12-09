package edu.eci.arep.productConsulting.Controllers;

import edu.eci.arep.productConsulting.Entities.Producto;
import edu.eci.arep.productConsulting.Repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/productos")
public class ProductoController{
    @Autowired
    private ProductoRepository productoRepository;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<?> productos(){
        try {
	        return new ResponseEntity<>(productoRepository.findAll(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> productoById(@PathVariable("id") String productoId){
        try {
	        return new ResponseEntity<>(productoRepository.findById(productoId),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> postProducto(@RequestBody Producto p){
        try {
			productoRepository.insert(p);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<?> updateProducto(@RequestBody Producto p){
        try {
			productoRepository.save(p);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteProducto(@PathVariable("id") String productoId){
        try {
			productoRepository.deleteById(productoId);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }

    @DeleteMapping("/deleteAll")
	public ResponseEntity<?> deleteAll(){
    	productoRepository.deleteAll();
    	return new ResponseEntity<>(HttpStatus.OK);
	}

}
