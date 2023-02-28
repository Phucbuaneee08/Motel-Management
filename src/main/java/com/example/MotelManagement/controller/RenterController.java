package com.example.MotelManagement.controller;
import com.example.MotelManagement.entities.Renter;
import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.repository.RoomRepository;
import com.example.MotelManagement.service.RenterService;
import com.example.MotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping()

public class RenterController {
    RoomRepository roomRepository;
    @Autowired
    private RenterService renterService;
    @Autowired
    private RoomService roomService;

    public RenterController(RenterService renterService) {
        super();
        this.renterService = renterService;
    }
    //handle method to handle list student
    @GetMapping("/renters")
    public String listRenter(Model model){
        model.addAttribute("renter",renterService.getAllRenters().stream().sorted(Comparator.comparing(Renter::getRoomName)).collect(Collectors.toList()));
        Renter renter = new Renter();
        Renter renter2 = new Renter();
        Room room =new Room();
        model.addAttribute("room",room);
        List<Room> rooms = roomService.getAllRooms();
        model.addAttribute("rooms",rooms);
        model.addAttribute("renter1",renter);
        model.addAttribute("renter2",renter2);
        return "renters";
    }
    @GetMapping("/renters/{id}")
    public String deleteRenter(@PathVariable Long id) {
        renterService.deleteRenterById(id);
        return "redirect:/renters";
    }
    @GetMapping("/renters/add")
    public String createNewRenter(Model model){
        Renter renter = new Renter();
        Room room =new Room();
        model.addAttribute("renter",renter);
        model.addAttribute("room",room);
        return "add_renter";
    }
    @PostMapping("/renters/add")
    public String saveRenter(@ModelAttribute("renter1") Renter renter1,@ModelAttribute("room") Room room){
        Room room1 = roomService.getRoomByName(room.getName());
        if(room1==null) return "redirect:/renters?error_room";
        else{
            if(room1.getIsRented()==1){
                renterService.saveRenter(renter1,room1);
                return "redirect:/renters?success";
            }
            else return "redirect:/renters?error_contract";
        }
    }
    @GetMapping("/renters/edit/{id}")
    public String editRoom(@PathVariable long id,Model model){
        model.addAttribute("renter",renterService.getRenterById(id));
        model.addAttribute("room",new Room());
        return "edit_renter";
    }
    @PostMapping("/renters/edit/{id}")
    public String updateRoom(@PathVariable long id,
                             @ModelAttribute("renter2") Renter renter2,
                             @ModelAttribute("room") Room room,
                             Model model){
        Renter existingRenter = renterService.getRenterById(id);
        existingRenter.setRenterName(renter2.getRenterName());
        existingRenter.setJob(renter2.getJob());
        existingRenter.setIdentification(renter2.getIdentification());
        existingRenter.setPhoneNumber(renter2.getPhoneNumber());
        existingRenter.setResidence(renter2.getResidence());
        renterService.updateRenter(existingRenter);
        return "redirect:/renters";

    }
//    @GetMapping("/rooms/{id}")
//    public String deleteRoom(@PathVariable Long id) {
//        roomService.deleteRoomById(id);
//        return "redirect:/rooms";
//    }
//
//    @GetMapping(value = {"/","/dashboard"})
//    public String index(Model model){
//        model.addAttribute("room",roomService.getAllRooms());
//        return "dashboard";
//    }
}
