package com.example.MotelManagement.service;

import com.example.MotelManagement.entities.Room;

import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room saveRoom(Room room);
    Room updateRoom(Room room);
    Room getRoomByName(String name);
    Room getRoomById(Long id);
    void deleteRoomById(Long id);
}
