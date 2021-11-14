package by.itacademy.mikhalevich.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
public class Trip extends AbstractEntity {

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @JoinTable(name = "trip_bill",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id"))
    private Set<Bill> bills = new LinkedHashSet<>();

    public void addBill(Bill bill) {
        bills.add(bill);
        bill.getTrips().add(this);
    }

    public void removeBill(Bill bill) {
        bills.remove(bill);
        bill.getTrips().remove(this);
    }

    private String plane;
    @Column(name = "town_from")
    private String townFrom;
    @Column(name = "town_to")
    private String townTo;
    @Column(name = "time_out")
    private Timestamp timeOut;
    @Column(name = "time_in")
    private Timestamp timeIn;

}
