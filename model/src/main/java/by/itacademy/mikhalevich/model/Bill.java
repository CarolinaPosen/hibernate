package by.itacademy.mikhalevich.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"trips", "passenger"})
@EqualsAndHashCode(callSuper = false, exclude = {"trips", "passenger"})
@Entity
public class Bill extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToMany(mappedBy = "bills")
    private Set<Trip> trips = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "bill_service",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "bill_id"))
    private Set<Service> services = new LinkedHashSet<>();

    public void addTrip(Trip trip) {
        trips.add(trip);
        trip.getBills().add(this);
    }

    public void removeTrip(Trip trip) {
        trips.remove(trip);
        trip.getBills().remove(this);
    }

}
