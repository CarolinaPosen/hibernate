package by.itacademy.mikhalevich;

import by.itacademy.mikhalevich.model.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDto {

    private Company company;
    private String plane;

}
