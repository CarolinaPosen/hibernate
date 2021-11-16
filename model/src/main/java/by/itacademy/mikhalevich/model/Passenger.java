package by.itacademy.mikhalevich.model;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Entity;
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

}
