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
@DiscriminatorValue("transfer_trip")
@Entity
@Table(name="transfer_trip", schema = "public")
public class TransferTrip extends Trip {
    @Column(name = "transfer_town")
    private String transferTown;
    @Column(name = "transfer_time_out")
    private Date transferTimeOut;
    @Column(name = "transfer_time_in")
    private Date transferTimeIn;
}
