package by.itacademy.mikhalevich.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Entity
@NamedQuery(name = "byName", query = "select new com.itacademy.mikhalevich.dto.PassengerDto(p.name) from Passenger p where p.name = :name")
public class Passenger extends AbstractEntity {

    private String name;

    @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Credential credentials;

    @OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
    Set<Bill> bills = new LinkedHashSet<>();

    public Passenger withId(Integer id){
        setId(id);
        return this;
    }

    public Passenger withName(String name) {
        setName(name);
        return this;
    }

    public void addBill(Bill bill) {
        bills.add(bill);
        bill.setPassenger(this);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
        bill.setPassenger(this);
    }

    public Passenger(String name) {
        this.name = name;
    }
}
