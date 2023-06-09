package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.SeatDTO;
import com.example.cinema_back_end.entities.Room;
import com.example.cinema_back_end.entities.Seat;
import com.example.cinema_back_end.repositories.IScheduleRepository;
import com.example.cinema_back_end.repositories.ISeatRepository;
import com.example.cinema_back_end.repositories.ITicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatService implements ISeatService{
    @Autowired
    private ISeatRepository seatRepository;
    @Autowired
    private IScheduleRepository scheduleRepository;
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SeatDTO> getSeatsByScheduleId(Integer scheduleId) {
        Room room = scheduleRepository.getById(scheduleId).getRoom();
        List<Seat> listSeat = seatRepository.getSeatByRoom_Id(room.getId());

        List<Seat> occupiedSeats = ticketRepository.findTicketsBySchedule_Id(scheduleId)
                .stream().map(ticket -> ticket.getSeat())
                .collect(Collectors.toList());

        List<SeatDTO> filteredSeats = listSeat.stream().map(seat -> {
           SeatDTO seatDTO = modelMapper.map(seat,SeatDTO.class);
           if(occupiedSeats.stream()
                   .map(occupiedSeat->occupiedSeat.getId())
                   .collect(Collectors.toList()).contains(seat.getId())){
               seatDTO.setIsOccupied(1);
           }
           return seatDTO;
        }).collect(Collectors.toList());
        return  filteredSeats;
    }
}
