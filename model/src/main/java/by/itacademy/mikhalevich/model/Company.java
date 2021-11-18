package by.itacademy.mikhalevich.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString(callSuper = true, exclude = "trips")
@EqualsAndHashCode(callSuper = true, exclude = "trips")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name="company", schema = "public")
public class Company extends AbstractEntity {

    private String name;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private Set<Trip> trips = new LinkedHashSet<>();

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private Ident ident;

    public void addTrip(Trip trip){
        trips.add(trip);
        trip.setCompany(this);
    }

}
