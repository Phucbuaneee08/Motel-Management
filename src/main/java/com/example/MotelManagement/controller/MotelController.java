package com.example.MotelManagement.controller;

import com.example.MotelManagement.entities.Motel;
import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.repository.MotelRepository;
import com.example.MotelManagement.service.MotelService;
import com.example.MotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping()
public class MotelController {
    MotelRepository motelRepository;
    @Autowired
    private RoomService roomService;
    @Autowired
    private MotelService motelService;

    public MotelController(MotelService motelService) {
        super();
        this.motelService = motelService;
    }

    @GetMapping("/my-motel")
    public String myMotel(Model model){
        model.addAttribute("motel",motelService.getMotelById(1L));
        return "motel";
    }
    @PostMapping("/my-motel")
    public String saveMotel(@ModelAttribute("motel") Motel motel){
        Optional<Motel> newMotel = motelService.getMotelById(1L);
        Date date = new Date();
        if(newMotel.isPresent()){
            newMotel.map(newMotel1->{
                newMotel1.setMotelElec(motel.getMotelElec());
                newMotel1.setMotelWater(motel.getMotelWater());
                newMotel1.setStartCountDate(motel.getStartCountDate());
                newMotel1.setEndCountDate(motel.getEndCountDate());
                if(newMotel1.getEndCountDate().compareTo(date)>=0&&newMotel1.getStartCountDate().compareTo(date)<=0){
                    newMotel1.setIsExpired(0);
                }
                else newMotel1.setIsExpired(1);
                return motelService.save(newMotel1);
            });
        }
        else{
            motelService.save(motel);
        }
        List<Room> listRoom1 = roomService.getAllRooms().stream().filter(room -> room.getIsRented()==1).collect(Collectors.toList());
        for(Room room : listRoom1) {
           room.setTotalPayment(0);
           roomService.saveRoom(room);
        }


        return "redirect:/my-motel";
    }
}
