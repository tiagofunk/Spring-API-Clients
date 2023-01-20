package funk.tiago.clients.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import funk.tiago.clients.domain.Adress;
import funk.tiago.clients.domain.Client;
import funk.tiago.clients.service.ClientService;

@RestController
@RequestMapping("clients")
public class ClientController {
    private final ClientService clientService;
    
    
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> list(){
        return new ResponseEntity<>(clientService.listAll(), HttpStatus.OK);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Client> findById(@PathVariable int id){
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path="/adresses/{id}")
    public ResponseEntity<List<Adress>> findAdressesById(@PathVariable int id){
        return new ResponseEntity<>(clientService.findAdressesById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client ){
        return new ResponseEntity<>(clientService.save( client ), HttpStatus.CREATED);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        clientService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Client client){
        clientService.replace(client);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "adresses/{idClient}")
    public ResponseEntity<Void> addAdress(@PathVariable int idClient, @RequestBody Adress adress){
        clientService.addAdress( idClient, adress );
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
