package funk.tiago.clients.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import funk.tiago.clients.domain.Client;
import funk.tiago.clients.domain.Adress;

@Service
public class ClientService {

    private static List<Client> clients;
    static {
        clients = new ArrayList<>(List.of(
            new Client("Tiago", new Date("03/03/1996"),
                    new Adress("Rua a", "89222888", "1000", "Joinville")),
            new Client("Viviane", new Date("03/03/1996"),
                    new Adress("Rua a", "89222888", "1000", "Joinville"))));
    }

    public List<Client> listAll() {
        return clients;
    }

    public Client findByName(String name) {
        return clients.stream().filter(c -> c.getName().equals(name)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client not found!"));
    }

    public Client save(Client client) {
        clients.add(client);
        return client;
    }

    public void delete(String name) {
        clients.remove(findByName(name));
    }

    public void replace(Client client) {
        delete(client.getName());
        clients.add(client);
    }
}
