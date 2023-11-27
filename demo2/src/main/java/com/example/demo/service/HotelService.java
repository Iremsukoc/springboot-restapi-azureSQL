package com.example.demo.service;


import com.example.demo.dto.HotelidDTO;
import com.example.demo.model.Hotel;
import com.example.demo.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;


    public List<Hotel> getHotelsAccordingParameters(Date dateFrom, Date dateTo, String city, int totalDay, int guest,int pageNo, int record) {
        Pageable pageable =  PageRequest.of(pageNo,record);
        List<Hotel> hotels = hotelRepository.findAllBetweenDates(dateFrom, dateTo, city, totalDay, guest,pageable);
        return hotels;    }


    public List<Hotel> getAllHotels(int pageNo, int record) {
        Pageable pageable =  PageRequest.of(pageNo,record);
        List<Hotel> hotels = hotelRepository.getAllHotels(pageable);
        return hotels;    }

    public void deleteReservation(HotelidDTO hotelidDTO) throws Exception {
        hotelRepository.deleteById(hotelidDTO.getHotelID());

    }


}
