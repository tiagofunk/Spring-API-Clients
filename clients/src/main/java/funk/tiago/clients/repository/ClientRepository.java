package funk.tiago.clients.repository;

import org.springframework.data.repository.CrudRepository;

import funk.tiago.clients.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

    Client findById(long id);

}
