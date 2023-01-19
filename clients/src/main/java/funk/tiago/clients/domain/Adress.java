package funk.tiago.clients.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;
    public String street;
    public String cep;
    public String number;
    public String city;

    public Adress(){}

    public Adress(String street, String cep, String number, String city) {
        this.street = street;
        this.cep = cep;
        this.number = number;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Adress [id=" + id + ", street=" + street + ", cep=" + cep + ", number=" + number + ", city=" + city
                + "]";
    }

}
