package br.com.andre.mqtt.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Weight {

    private BigDecimal weight;
    private LocalDate date;

}
