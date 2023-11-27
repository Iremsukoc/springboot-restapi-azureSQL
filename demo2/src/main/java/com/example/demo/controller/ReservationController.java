package com.example.demo.controller;


import com.example.demo.dto.*;
import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;



    @GetMapping(value= "/reservations/{pageNo}/{recordCount}")
    public List<Reservation> getAllReservations(@PathVariable int pageNo, @PathVariable int recordCount) {
        Page<Reservation> reservationPage = reservationService.getAllReservations(pageNo, recordCount);

        List<Reservation> reservations = reservationPage.getContent();

        return reservations;
    }

    @GetMapping(value= "/reservations-by-id")
    public ReservationResponseDTO getReservationById(@RequestBody ReservationidDTO id) {
        return reservationService.getReservationById (id);

    }

    @DeleteMapping(value="/delete-reservation-by-id")
    public BookingResponseDTO deleteReservation(@RequestBody HotelidDTO hotelidDTO) {
        try {
            reservationService.deleteReservation(hotelidDTO);
            return new BookingResponseDTO("OK");
        } catch (Exception e) {
            return new BookingResponseDTO("Not Deleted");
        }
    }


    @PostMapping(value="/make-reservation")
    public BookingResponseDTO validateAndSaveReservation(
            @RequestBody BookingRequestDTO bookingRequestDTO) {
        try {
            System.out.println("Response" + bookingRequestDTO.getTravelerNameList());
            BookingResponseDTO response = reservationService.makeReservation(bookingRequestDTO.getFromDate(), bookingRequestDTO.getToDate(), bookingRequestDTO.getTravelerNameList(), bookingRequestDTO.getHotelID(), bookingRequestDTO.getDate());
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return new BookingResponseDTO("Not Added");
        }
    }


}
