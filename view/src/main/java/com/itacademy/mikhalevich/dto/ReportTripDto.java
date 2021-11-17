package com.itacademy.mikhalevich.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportTripDto {
    private String plane;
    private String townFrom;
    private String townTo;
}
