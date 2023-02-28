package com.example.MotelManagement.controller;
import com.example.MotelManagement.entities.Contract;
import com.example.MotelManagement.entities.Renter;
import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.service.ContractService;
import com.example.MotelManagement.service.RenterService;
import com.example.MotelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
//youaresohandsome
public class ContractController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private RenterService renterService;
    public ContractController(ContractService contractService) {
        super();
        this.contractService = contractService;
    }
    //handle method to handle list student
//    @GetMapping("/rooms")
//    public String listRoom(Model model){
//        model.addAttribute("room",roomService.getAllRooms());
//        return "rooms";
//    }
//    @GetMapping("/rooms/add")
//    public String createNewRoom(Model model){
//        Room room = new Room();
//        model.addAttribute("room",room);
//        return "createRoom";
//    }
//    @PostMapping("/rooms")
//    public String saveRoom(@ModelAttribute("room") Room room){
//        roomService.saveRoom(room);
//        return "redirect:/rooms";
//    }
    @GetMapping("/rooms/view-contract/{id}")
    public String viewContract(@PathVariable long id,Model model){
        List<Renter> listRenter = renterService.getRenterByRoomId(id);
        Renter head = new Renter();
        for (Renter renter: listRenter
             ) {
            if(renter.getIsHeader()==1) head=renter;
        }
        Room room = roomService.getRoomById(id);
        if(room.getIsRented()==0){
            return "redirect:/rooms?not_exist_contract";
        }
        else{
        model.addAttribute("room",room);
        model.addAttribute("contract",contractService.getContractByRoomId(id));
        model.addAttribute("renter",head);
        return "view_contract";}
    }
    @GetMapping("/rooms/view-contract/delete/{id}")
    public String deleteContract(@PathVariable Long id) {
        contractService.deleteContractByRoomId(id);
        List<Renter> listRenter = renterService.getRenterByRoomId(id);
        for (Renter renter: listRenter
             ) { renterService.deleteRenterById(renter.getId());
        }
        Room room = roomService.getRoomById(id);
        room.setIsRented(0);
        roomService.saveRoom(room);
        return "redirect:/rooms";
    }
    @GetMapping("/rooms/contract/{id}")
    public String addContract(@PathVariable long id,Model model){
        Contract contract = new Contract();
        Renter renter = new Renter();
        model.addAttribute("room",roomService.getRoomById(id));
        model.addAttribute("contract",contract);
        model.addAttribute("renter",renter);
        return "add_contract";
    }

    @PostMapping("/rooms/contract/{id}")
    public String saveContract(@ModelAttribute("contract") Contract contract,@ModelAttribute("renter") Renter renter,@PathVariable long id){
        Room room = roomService.getRoomById(id);
        if(room.getIsRented()==0){
        contractService.saveContract(contract,room);
        renter.setIsHeader(1);
        renterService.saveRenter(renter,room);
        room.setIsRented(1);
        roomService.updateRoom(room);
        return "redirect:/rooms?success_contract";}
        else return "redirect:/rooms?exist_contract";
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
//    @PostMapping("/rooms/edit/{id}")
//    public String updateRoom(@PathVariable long id,
//                             @ModelAttribute("room") Room room,
//                             Model model){
//        Room existingRoom = roomService.getRoomById(id);
//        existingRoom.setPrice(room.getPrice());
//        existingRoom.setElecIndex(room.getElecIndex());
//        existingRoom.setName(room.getName());
//        existingRoom.setDescription(room.getDescription());
//        existingRoom.setElecUnit(room.getElecUnit());
//        existingRoom.setSquare(room.getSquare());
//        existingRoom.setWaterIndex(room.getWaterIndex());
//        existingRoom.setWaterUnit(room.getWaterUnit());
//        roomService.updateRoom(existingRoom);
//        return "redirect:/rooms";
//
//    }
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
