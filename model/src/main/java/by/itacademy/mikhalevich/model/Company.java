package by.itacademy.mikhalevich.model;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Company extends AbstractEntity<Integer> {
    private BigDecimal salary;
    private Timestamp date;

    public Company withId(Integer id){
        setId(id);
        return this;
    }

    public Company withSalary(BigDecimal salary) {
        setSalary(salary);
        return this;
    }
    public Company withDate(Timestamp date){
        setDate(date);
        return this;
    }



}
