package com.example.cinema_back_end.services;

import com.example.cinema_back_end.dtos.BookingRequestDTO;
import com.example.cinema_back_end.entities.Bill;
import com.example.cinema_back_end.entities.Schedule;
import com.example.cinema_back_end.entities.Ticket;
import com.example.cinema_back_end.entities.User;
import com.example.cinema_back_end.repositories.IBillRepository;
import com.example.cinema_back_end.repositories.IScheduleRepository;
import com.example.cinema_back_end.repositories.ISeatRepository;
import com.example.cinema_back_end.repositories.ITicketRepository;
import com.example.cinema_back_end.security.repo.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BillService implements IBillService{
    @Autowired
    private IScheduleRepository scheduleRepository;
    @Autowired
    private ITicketRepository ticketRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private ISeatRepository seatRepository;
    @Autowired
    private IBillRepository billRepository;

    @Override
    @Transactional
    public void createNewBill(BookingRequestDTO bookingRequestDTO) throws RuntimeException {

        Schedule schedule = scheduleRepository.getById(bookingRequestDTO.getScheduleId());
        User user = userRepository.getById(bookingRequestDTO.getUserId());

        Bill billToCreate = new Bill();
        billToCreate.setUser(user);
        billToCreate.setCreatedTime(LocalDateTime.now());
        Bill createdBill = billRepository.save(billToCreate);

        bookingRequestDTO.getListSeatIds().forEach(seatId->{
            if(!ticketRepository.findTicketsBySchedule_IdAndSeat_Id(schedule.getId(),seatId)
                    .isEmpty()){
                throw new RuntimeException("Đã có người nhanh tay hơn đặt ghế, mời bạn chọn lại!");
            }
            Ticket ticket = new Ticket();
            ticket.setSchedule(schedule);
            ticket.setSeat(seatRepository.getById(seatId));
            ticket.setBill(createdBill);
            ticket.setQrImageURL("https://scontent-sin6-2.xx.fbcdn.net/v/t1.15752-9/268794058_655331555823095_3657556108194277679_n.png?_nc_cat=105&ccb=1-5&_nc_sid=ae9488&_nc_ohc=BrNXGO8HufkAX_OGjWc&_nc_ht=scontent-sin6-2.xx&oh=03_AVK_zaJj7pziY9nLrVqoIQJAzbomu4KPgED1PxFFpYfCrQ&oe=61F778D8");
            ticketRepository.save(ticket);
        });
    }
}
