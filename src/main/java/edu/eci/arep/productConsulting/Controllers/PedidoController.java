package edu.eci.arep.productConsulting.Controllers;

import edu.eci.arep.productConsulting.Entities.Pedido;
import edu.eci.arep.productConsulting.Repository.PedidoRepository;

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
public class PedidoController{
    @Autowired
    private PedidoRepository PedidoRepository;

    @RequestMapping(value="/Pedido",method=RequestMethod.GET)
    public ResponseEntity<?> Pedidos(){
        try {
	        return new ResponseEntity<>(PedidoRepository.findAll(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(value="/Pedido/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> PedidoById(@PathVariable("id") String PedidoId){
        try {
	        return new ResponseEntity<>(PedidoRepository.findById(PedidoId),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(value="/Pedido",method=RequestMethod.POST)
    public ResponseEntity<?> postPedido(@RequestBody Pedido p){
        try {
			PedidoRepository.insert(p);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}
    }

    @RequestMapping(value="/Pedido",method=RequestMethod.PUT)
    public ResponseEntity<?> updatePedido(@RequestBody Pedido p){
        try {
			PedidoRepository.save(p);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }
    @RequestMapping(value="/Pedido/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deletePedido(@PathVariable("id") String PedidoId){
        try {
			PedidoRepository.deleteById(PedidoId);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }
}
