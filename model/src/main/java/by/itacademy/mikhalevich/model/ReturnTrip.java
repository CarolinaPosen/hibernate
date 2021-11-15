package by.itacademy.mikhalevich.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("return_trip")
@Entity
public class ReturnTrip extends Trip {
    private Timestamp returnTimeIn;
    private Timestamp returnTimeOut;
}
