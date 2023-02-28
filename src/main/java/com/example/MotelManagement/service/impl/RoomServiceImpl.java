package com.example.MotelManagement.service.impl;

import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.repository.RoomRepository;
import com.example.MotelManagement.service.RoomService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        super();
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> getAllRooms() {

        return roomRepository.findAll();
    }

    @Override
    public Room saveRoom(Room room) {

        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room getRoomByName(String name) {
        return roomRepository.findByName(name);
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public void deleteRoomById(Long id) {
        roomRepository.deleteById(id);
    }

}
