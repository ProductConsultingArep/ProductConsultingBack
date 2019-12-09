package edu.eci.arep.productConsulting.Controllers;

import edu.eci.arep.productConsulting.Entities.Orden;
import edu.eci.arep.productConsulting.Entities.Pedido;
import edu.eci.arep.productConsulting.Repository.OrdenRepository;
import edu.eci.arep.productConsulting.Repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/pedidos")
public class PedidoController{
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
	private OrdenRepository ordenRepository;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<?> Pedidos(){
        try {
	        return new ResponseEntity<>(pedidoRepository.findAll(),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ResponseEntity<?> PedidoById(@PathVariable("id") String PedidoId){
        try {
	        return new ResponseEntity<>(pedidoRepository.findById(PedidoId),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
	    }
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> postPedido(@RequestBody Pedido p){
        try {
			ordenRepository.insert(p.getOrdenes());
			pedidoRepository.insert(p);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);

		}
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<?> updatePedido(@RequestBody Pedido p){
        try {
			pedidoRepository.save(p);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<?> deletePedido(@PathVariable("id") String PedidoId){
        try {
			pedidoRepository.deleteById(PedidoId);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("error", HttpStatus.NOT_FOUND);
		}
    }

	@DeleteMapping("/deleteAll")
	public ResponseEntity<?> deleteAll(){
		pedidoRepository.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
