package com.example.demo.controller;


import com.example.demo.dto.BookingResponseDTO;
import com.example.demo.dto.HotelidDTO;
import com.example.demo.dto.QueryRequestDTO;
import com.example.demo.model.Hotel;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class HotelController {



    @Autowired
    private HotelService hotelService;


    @PostMapping (value = "/hotels-with-parameters/{pageNo}/{recordCount}")
    public List<Hotel> getHotelsAccordingParameters(@RequestBody QueryRequestDTO queryRequestDTO, @PathVariable int pageNo, @PathVariable int recordCount) {
        Date fromDate = queryRequestDTO.getFromDate();
        Date toDate = queryRequestDTO.getToDate();
        String city = queryRequestDTO.getCity();
        int totalDay = queryRequestDTO.getDate();
        int guest = queryRequestDTO.getNumberOfPeople();

        return hotelService.getHotelsAccordingParameters(fromDate, toDate, city, totalDay, guest, pageNo, recordCount);
    }

    @GetMapping("/hotels/{pageNo}/{recordCount}")
    public List<Hotel> getHotels(@PathVariable int pageNo, @PathVariable int recordCount)
    {
        return hotelService.getAllHotels(pageNo, recordCount);
    }

    @DeleteMapping(value="/delete-hotel-by-id")
    public BookingResponseDTO deleteHotel(@RequestBody HotelidDTO hotelidDTO) {
        try {
            hotelService.deleteReservation(hotelidDTO);
            return new BookingResponseDTO("OK");
        } catch (Exception e) {
            return new BookingResponseDTO("Not Deleted");
        }
    }
}
