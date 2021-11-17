package by.itacademy.mikhalevich.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("return_trip")
@Entity
@Table(name = "return_trip", schema = "public")
public class ReturnTrip extends Trip {
    @Column(name = "return_time_in")
    private Date returnTimeIn;
    @Column(name = "return_time_out")
    private Date returnTimeOut;
}
