package com.example.MotelManagement.service.impl;

import com.example.MotelManagement.entities.Motel;
import com.example.MotelManagement.repository.MotelRepository;
import com.example.MotelManagement.service.MotelService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MotelServiceImpl implements MotelService {
    private MotelRepository motelRepository;
    public MotelServiceImpl(MotelRepository motelRepository) {
        super();
        this.motelRepository = motelRepository;
    }

    @Override
    public Motel save(Motel motel) {
        return motelRepository.save(motel);
    }

    @Override
    public Optional<Motel> getMotelById(Long id) {
        Optional<Motel> motel = motelRepository.findById(id);
        return motel;
    }
}
