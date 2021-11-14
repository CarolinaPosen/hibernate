package by.itacademy.mikhalevich.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name="ident", schema = "public")
public class Ident extends AbstractEntity {

    @Column(name="serial")
    private String serial;


}