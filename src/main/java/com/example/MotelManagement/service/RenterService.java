package com.example.MotelManagement.service;

import com.example.MotelManagement.entities.Contract;
import com.example.MotelManagement.entities.Renter;
import com.example.MotelManagement.entities.Room;

import java.util.List;

public interface RenterService {
    Renter saveRenter(Renter renter,Room room);
    List<Renter> getRenterByRoomId(long roomId);
    Renter updateRenter(Renter renter);
    void deleteRenterById(Long id);
    Renter getRenterById(Long id);

    List<Renter> getAllRenters();
}
