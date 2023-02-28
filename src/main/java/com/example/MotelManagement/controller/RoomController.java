package com.example.MotelManagement.controller;
import com.example.MotelManagement.entities.Contract;
import com.example.MotelManagement.entities.Motel;
import com.example.MotelManagement.entities.Renter;
import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.service.MotelService;
import com.example.MotelManagement.service.RenterService;
import com.example.MotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping()
//youaresohandsome
public class RoomController {
    @Autowired
    private MotelService motelService;
    @Autowired
    private RenterService renterService;
    @Autowired
    private RoomService roomService;

    public RoomController(RoomService roomService) {
        super();
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public String listRoom(Model model){
        Room room2 = new Room();
        Contract contract = new Contract();
        Renter renter = new Renter();
        model.addAttribute("contract",contract);
        model.addAttribute("renter",renter);
        model.addAttribute("room2",room2);
        model.addAttribute("room",roomService.getAllRooms().stream().sorted(Comparator.comparing(Room::getName)).collect(Collectors.toList()));
        return "rooms";
    }
    @GetMapping("/rooms/add")
    public String createNewRoom(Model model){
        Room room = new Room();
        model.addAttribute("room",room);
        return "add_room";
    }
    @PostMapping("/rooms/add")
    public String saveRoom(@ModelAttribute("room2") Room room2){
        int count = 0;
        Optional<Motel> motel = motelService.getMotelById(1L);
        List<Room> listRoom = roomService.getAllRooms();
        for (Room room1:listRoom){
            if(room1.getName().compareTo(room2.getName())==0) count+=1;
            System.out.println(count);
        }
        if(count==0){
        motel.map(motel1 -> {
            room2.setWaterUnit(motel1.getMotelWater());
            room2.setElecUnit(motel1.getMotelElec());
            return roomService.saveRoom(room2);
        });
        return "redirect:/rooms?success";
        }
        else return "redirect:/rooms?error_exist";
    }
    @GetMapping("/rooms/view/{id}")
    public String viewRoom(@PathVariable long id,Model model){
        model.addAttribute("room",roomService.getRoomById(id));
        model.addAttribute("renter",renterService.getRenterByRoomId(id));
        return "index";
    }
    @GetMapping("/rooms/edit/{id}")
    public String editRoom(@PathVariable long id,Model model){
        model.addAttribute("room",roomService.getRoomById(id));

        return "edit_room";
    }
    @PostMapping("/rooms/edit/{id}")
    public String updateRoom(@PathVariable long id,
                             @ModelAttribute("room") Room room,
                             Model model){

        Room existingRoom = roomService.getRoomById(id);
        existingRoom.setPrice(room.getPrice());
        existingRoom.setElecIndex(room.getElecIndex());
        existingRoom.setName(room.getName());
        existingRoom.setDescription(room.getDescription());
        existingRoom.setElecUnit(room.getElecUnit());
        existingRoom.setSquare(room.getSquare());
        existingRoom.setWaterIndex(room.getWaterIndex());
        existingRoom.setWaterUnit(room.getWaterUnit());
        roomService.updateRoom(existingRoom);
        return "redirect:/rooms?success";

    }
    @GetMapping("/rooms/{id}")
    public String deleteRoom(@PathVariable Long id) {
        roomService.deleteRoomById(id);
        return "redirect:/rooms";
    }

    @GetMapping(value = {"/","/dashboard"})
    public String index(Model model){
        model.addAttribute("room",roomService.getAllRooms());
        return "dashboard";
    }
}
