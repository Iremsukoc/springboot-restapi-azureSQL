package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id", nullable = false)
    private long hotelID;

    @Column(name = "description")
    private String description;

    @Column(name = "total_day")
    private int totalDay;

    @Temporal(TemporalType.DATE)
    @Column(name = "available_from")
    private Date availableFrom;


    @Temporal(TemporalType.DATE)
    @Column(name = "available_to")
    private Date availableTo;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "city")
    private String city;

    @Column(name="guest_capacity")
    private int guest_capacity;

    public boolean isDateInRange(Date checkDate) {
        return availableFrom.compareTo(checkDate) <= 0 && availableTo.compareTo(checkDate) >= 0;
    }

}
