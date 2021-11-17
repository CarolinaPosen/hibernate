package com.itacademy.mikhalevich.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dom4j.tree.AbstractEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto extends AbstractEntity {
    private String name;
}
