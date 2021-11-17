package com.itacademy.mikhalevich.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {

    private String companyName;
    private String plane;
    private String townFrom;
    private String townTo;

}
