package funk.tiago.clients.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import funk.tiago.clients.domain.Adress;
import funk.tiago.clients.domain.Client;
import funk.tiago.clients.repository.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> listAll() {
        Iterator<Client> myIterator = (Iterator<Client>) clientRepository.findAll().iterator();
        List<Client> list = new ArrayList<>();
        myIterator.forEachRemaining(list::add);
        return list;
    }

    public Client findById(int id) {
        return clientRepository.findById(id);
    }

    public List<Adress> findAdressesById(int id) {
        return clientRepository.findById(id).getAdresses();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(int id) {
        clientRepository.delete(findById(id));
    }

    public void replace(Client client) {
        if( clientRepository.existsById(client.getId()) ){
            clientRepository.save(client);
        }
    }

    public void addAdress(int idClient, Adress adress) {
        Client c = findById(idClient);
        c.getAdresses().add(adress);
        clientRepository.save(c);
    }

    public void createMainAdress(int idClient, int idAdress) {
        Client c = findById(idClient);
        c.setMainAdress(idAdress);
        clientRepository.save(c);
    }
}
