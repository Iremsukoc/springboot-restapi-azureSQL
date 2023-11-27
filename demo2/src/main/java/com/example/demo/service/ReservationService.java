package com.example.demo.service;


import com.example.demo.dto.BookingResponseDTO;
import com.example.demo.dto.HotelidDTO;
import com.example.demo.dto.ReservationResponseDTO;
import com.example.demo.dto.ReservationidDTO;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Page<Reservation> getAllReservations(int pageNo, int record) {
        Pageable pageable = PageRequest.of(pageNo, record);
        return reservationRepository.findAll(pageable);
    }

    public ReservationResponseDTO getReservationById(ReservationidDTO reservationidDTO) {
        ReservationResponseDTO reservationResponseDTO = new ReservationResponseDTO ();

         Reservation reservation = reservationRepository.findByID (reservationidDTO.getReservationID ())
                .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + reservationidDTO.getReservationID ()));

         reservationResponseDTO.setReservationID (reservation.getReservationID ());
         reservationResponseDTO.setDate (reservation.getDate ());
         reservationResponseDTO.setCheckIn (reservation.getCheckIn ());
         reservationResponseDTO.setCheckOut (reservation.getCheckOut ());
         reservationResponseDTO.setGuestNames (reservation.getGuestNames ());

         return reservationResponseDTO;
    }

    public static int countGuestNames(List<String> guestNameList) {
        if (guestNameList == null) {
            return 0;
        }
        return guestNameList.size();
    }

    public Integer getTotalGuestNumberForHotelInDateRange(Long hotelId, Date startDate, Date endDate) {
        System.out.println(reservationRepository.findReservationsForHotelInDateRange(hotelId, startDate, endDate));
        List<Integer> guest_number = reservationRepository.findReservationsForHotelInDateRange(hotelId, startDate, endDate);
        System.out.println(guest_number);

        int totalGuest = 0;
        for (Integer guest : guest_number) {
            if (guest_number != null) {
                totalGuest += guest;
            }
        }

        System.out.println("total guest" + totalGuest);
        return totalGuest;
    }


    public void deleteReservation(HotelidDTO hotelidDTO) throws Exception {
        validateReservationExistence(hotelidDTO.getHotelID());
        reservationRepository.deleteById(hotelidDTO.getHotelID());

    }

    public boolean validateReservationExistence(Long id) throws Exception {
        if(!reservationRepository.existsById(id)){
            throw new Exception("Invalid ID existence");
        } else {
            return true;
        }
    }

    public BookingResponseDTO makeReservation(Date fromDate, Date toDate, List<String> namesOfPeople, Long hotelId, int date) {

        int numberOfGuests = countGuestNames(namesOfPeople);

        int totalGuestsInDateRange = getTotalGuestNumberForHotelInDateRange(hotelId, fromDate, toDate);
        System.out.println("totalGuestsInDateRange" + totalGuestsInDateRange);

        int totalGuestsIncludingAdditional = totalGuestsInDateRange + numberOfGuests;

        int hotel_capacity = reservationRepository.findGuestCapacityByHotelId(hotelId);
        List<Long> hotelid = reservationRepository.validDatesForHotel(hotelId, fromDate,toDate);

        if (hotelid.isEmpty())
        {
            return new BookingResponseDTO("Dates are wrong!");
        }
        if (totalGuestsIncludingAdditional > hotel_capacity) {
            return new BookingResponseDTO("Exceeded Capacity");
        } else {

            saveReservation(hotelId, fromDate,toDate,namesOfPeople, date);
            return new BookingResponseDTO("OK");
        }
    }

    public void saveReservation(Long hotelID, Date fromDate, Date toDate, List<String> namesOfPeople, int date)
    {
        Reservation newReservation = new Reservation();
        newReservation.setHotelID(hotelID); // Varsayılan olarak sadece bir otel döndüğünü varsayalım
        newReservation.setCheckIn(fromDate);
        newReservation.setCheckOut(toDate);
        newReservation.setGuestNames(String.join(",", namesOfPeople));
        int guestNumber = countGuestNames(namesOfPeople);
        newReservation.setGuestNumber(guestNumber);
        newReservation.setDate(date);

        reservationRepository.save(newReservation);
    }
}
