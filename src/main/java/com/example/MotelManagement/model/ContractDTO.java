package com.example.MotelManagement.model;

import com.example.MotelManagement.entities.Renter;
import com.example.MotelManagement.entities.Room;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ContractDTO {
    private int id;
    private int price;
    private Date rentalDay;
    private Date term;
    private Boolean status;
    private String Residence;
    private Room room;
    private List<Renter> listRenter;
}
