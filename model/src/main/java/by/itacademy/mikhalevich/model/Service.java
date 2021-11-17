package by.itacademy.mikhalevich.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString(callSuper = true, exclude = "bills")
@EqualsAndHashCode(callSuper = false, exclude = "bills")
@Entity
public class Service extends AbstractEntity {

    private String name;
    private Integer price;

    @ManyToMany(mappedBy = "services", cascade = CascadeType.ALL)
    private Set<Bill> bills = new LinkedHashSet<>();

}
