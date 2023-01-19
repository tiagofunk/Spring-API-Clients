package funk.tiago.clients.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private Date birthdate;
    @OneToMany(cascade=CascadeType.ALL)
    private List<Adress> adresses;

    public Client() {
    }

    public Client(String name, Date birthdate, List<Adress> adresses) {
        this.name = name;
        this.birthdate = birthdate;
        this.adresses = adresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    @Override
    public String toString() {
        String s = "Client [id=" + id + ", name=" + name + ", birthdate=" + birthdate + ", adresses=[\n";
        for (Adress a : this.adresses) {
            s += a.toString() + "\n";
        }
        s += "]";
        return s;

    }

}
