package by.itacademy.mikhalevich.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Passenger extends AbstractEntity<Integer> {

    private String name;

    public Passenger withId(Integer id){
        setId(id);
        return this;
    }

    public Passenger withName(String name) {
        setName(name);
        return this;
    }

/*    public Passenger addSalary(Company company){
        if(company !=null){
            salaries.add(company);
        }
        return this;
    }*/

    @Override
    public String toString() {
        return String.format("Passenger [id=%s, name=%s]", getId(), name);
    }
}
