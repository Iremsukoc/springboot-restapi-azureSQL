package com.example.demo.dto;


import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationResponseDTO {

    private long reservationID;
    private Date checkIn;
    private Date checkOut;
    private int date;
    private String guestNames;


}
