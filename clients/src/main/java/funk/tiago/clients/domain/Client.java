package funk.tiago.clients.domain;

import java.util.Date;

public class Client {
    private String name;
    private Date birthdate;
    private Adress adress;
    public Client(String name, Date birthdate, Adress adress) {
        this.name = name;
        this.birthdate = birthdate;
        this.adress = adress;
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
    public Adress getAdress() {
        return adress;
    }
    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    
}
