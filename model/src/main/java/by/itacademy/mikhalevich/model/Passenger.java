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
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Entity
public class Passenger extends AbstractEntity {

    private String name;

    @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Credentials credentials;

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

}
