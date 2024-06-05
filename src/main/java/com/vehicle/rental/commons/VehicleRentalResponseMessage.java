package com.vehicle.rental.commons;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VehicleRentalResponseMessage {
    private String message;
    private boolean success;
    private HttpStatus status;
}
