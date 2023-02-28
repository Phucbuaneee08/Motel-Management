package com.example.MotelManagement.controller;
import com.example.MotelManagement.entities.Motel;
import com.example.MotelManagement.entities.Payment;
import com.example.MotelManagement.entities.Renter;
import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.service.MotelService;
import com.example.MotelManagement.service.PaymentService;
import com.example.MotelManagement.service.RenterService;
import com.example.MotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/payments")
//youaresohandsome
public class PaymentController
{
    @Autowired
    private MotelService motelService;
    @Autowired
    private RenterService renterService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private PaymentService paymentService;
    private Date date = new Date();
    @GetMapping
    public String payment(Model model){
        Optional<Motel> motel = motelService.getMotelById(1L);
        List<Room> listRoom1 = roomService.getAllRooms().stream().filter(room -> room.getIsRented()==1).sorted(Comparator.comparing(Room::getName)).collect(Collectors.toList());
        for(Room room : listRoom1) {
            motel.map(motel1 -> {
                model.addAttribute("motel",motel1);
               if(motel1.getEndCountDate().compareTo(date)>0&&motel1.getStartCountDate().compareTo(date)<0){
                   room.setIsExpired(0);
                   if(room.getIsExpired()==0&&room.getIsPaid()==1){
                       room.setIsPaid(1);

                   }
               }
               else {room.setIsPaid(0);
                   System.out.println(0);}
               return roomService.saveRoom(room);
            });
        }
        model.addAttribute("room",listRoom1);

        return "payment";
    }
    @GetMapping("/status/{id}")
    public String paymentStatus(@PathVariable long id,Model model){
        model.addAttribute("room",roomService.getRoomById(id));
        return "payment_status";
    }
    @GetMapping("/history")
    public String paymentHistory(Model model){
        model.addAttribute("payment",paymentService.findAllPayment());
        return "payment_history";
    }
    @PostMapping("/status/{id}")
    public String maymentStatus(@PathVariable long id,@ModelAttribute("room") Room room){
        Room room1 = roomService.getRoomById(id);
        Payment payment = new Payment();
        Date date = new Date();
        room1.setElecIndex(room.getNewElecIndex());
        room1.setTotalPayment((room.getNewElecIndex()-room.getElecIndex())*room1.getElecUnit()
                                +(room.getNewWaterIndex()-room.getWaterIndex())*room1.getWaterUnit()+room1.getPrice());
        room1.setWaterIndex(room.getNewWaterIndex());
        room1.setNewElecIndex(room.getNewElecIndex());
        room1.setNewWaterIndex(room.getNewWaterIndex());
        room1.setIsPaid(1);
        payment.setPayDate(date);
        payment.setTotalPayment((room.getNewElecIndex()-room.getElecIndex())*room1.getElecUnit()
                +(room.getNewWaterIndex()-room.getWaterIndex())*room1.getWaterUnit()+room1.getPrice());
        paymentService.save(payment,room1);
        roomService.updateRoom(room1);
         return "redirect:/payments/status/{id}";
    }





}
