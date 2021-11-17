package by.itacademy.mikhalevich.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"trip","passenger"})
@EqualsAndHashCode(callSuper = false, exclude = {"trip","passenger"})
@Entity
public class Bill extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH})
    @JoinTable(name = "bill_service",
            joinColumns = @JoinColumn(name = "service_id"),
            inverseJoinColumns = @JoinColumn(name = "bill_id"))
    private Set<Service> services = new HashSet<>();

    public void addService(Service service) {
        services.add(service);
        service.getBills().add(this);
    }

    public void removeService(Service service) {
        services.remove(service);
        service.getBills().remove(this);
    }

}
