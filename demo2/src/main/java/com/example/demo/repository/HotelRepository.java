package com.example.demo.repository;

import com.example.demo.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.domain.Pageable;
import java.util.Date;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query(value = "SELECT * FROM hotel h WHERE h.available_from <= :dateFrom AND h.available_to >= :dateTo AND h.city = :city AND h.total_day >= :totalday AND h.guest_capacity >= :guest AND h.hotel_id NOT IN (SELECT r.hotel_id FROM reservation r WHERE (r.check_in >= :dateFrom AND r.check_out <= :dateTo))", nativeQuery = true)
    List<Hotel> findAllBetweenDates(@Param("dateFrom") Date dateFrom, @Param("dateTo") Date dateTo, @Param("city") String city, @Param("totalday") int totalday, @Param("guest") int guest, Pageable pageable);



    @Query(value = "SELECT * FROM hotel", nativeQuery = true)
    List<Hotel> getAllHotels(Pageable pageable);

}
