package com.example.demo.repository;


import com.example.demo.model.Hotel;
import com.example.demo.model.Reservation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    @Query(value = "SELECT r.guest_number FROM Reservation r " +
            "WHERE r.hotel_id = :hotelId " +
            "AND  r.check_in <=  :startDate AND  r.check_out >=  :endDate))", nativeQuery = true)
    List<Integer> findReservationsForHotelInDateRange(
            @Param("hotelId") Long hotelId,
            @Param("startDate") Date startDate,
            @Param("endDate") Date endDate);



    @Query(value = "SELECT r.guest_number FROM Reservation r WHERE r.reservationid = :reservationId", nativeQuery = true)
    Integer findGuestNumberByReservationId(@Param("reservationId") Long reservationId);


    @Query(value = "SELECT h.guest_capacity FROM Hotel h WHERE h.hotel_id = :hotelId", nativeQuery = true)
    Integer findGuestCapacityByHotelId(@Param("hotelId") Long hotelId);


    @Query(value = "SELECT hotel_id FROM hotel h " +
            "WHERE h.hotel_id = :hotelId " +
            "AND ((h.available_from <= :fromDate AND h.available_to >= :toDate))", nativeQuery = true)
    List<Long> validDatesForHotel(
            @Param("hotelId") Long hotelId,
            @Param("fromDate") Date fromDate,
            @Param("toDate") Date toDate);


    @Query(value = "SELECT * FROM newreservation WHERE reservationid = :id", nativeQuery = true)
    Optional<Reservation> findByID(@Param("id") Long id);




}
