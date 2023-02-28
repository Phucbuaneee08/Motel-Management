package com.example.MotelManagement.service.impl;

import com.example.MotelManagement.entities.Renter;
import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.repository.RenterRepository;
import com.example.MotelManagement.service.RenterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenterServiceImpl implements RenterService {
    RenterRepository renterRepository;
    public RenterServiceImpl(RenterRepository renterRepository){
        this.renterRepository=renterRepository;

    }
    @Override
    public Renter saveRenter(Renter renter, Room room) {
        renter.setRoom(room);
        return renterRepository.save(renter);
    }

    @Override
    public List<Renter> getRenterByRoomId(long id) {
        return  renterRepository.getRenterByRoomId(id);
    }


    @Override
    public Renter updateRenter(Renter renter) {
        return renterRepository.save(renter);
    }

    @Override
    public void deleteRenterById(Long id) {
        renterRepository.deleteById(id);
    }

    @Override
    public Renter getRenterById(Long id) {
        return renterRepository.findById(id).get();
    }

    @Override
    public List<Renter> getAllRenters() {
        return renterRepository.findAll();
    }
}
