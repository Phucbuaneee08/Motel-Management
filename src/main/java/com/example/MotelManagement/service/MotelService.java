package com.example.MotelManagement.service;

import com.example.MotelManagement.entities.Motel;

import java.util.Optional;

public interface MotelService {
    Motel save(Motel motel);
    Optional<Motel> getMotelById(Long id);

}
