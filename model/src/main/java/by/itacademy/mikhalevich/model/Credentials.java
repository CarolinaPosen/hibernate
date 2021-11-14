package by.itacademy.mikhalevich.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@ToString(exclude = "passenger")
@Data
@NoArgsConstructor
@SuperBuilder
@Entity
public class Credentials {
    @Id
    @Column(name = "passenger_id")
    private Integer id;

    private String login;
    private String password;

    @OneToOne
    @JoinColumn(name = "passenger_id")
    @MapsId
    private Passenger passenger;
}
