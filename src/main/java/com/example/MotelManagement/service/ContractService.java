package com.example.MotelManagement.service;

import com.example.MotelManagement.entities.Contract;
import com.example.MotelManagement.entities.Room;

import java.util.List;

public interface ContractService {
    Contract saveContract(Contract contract,Room room);
    Contract updateContract(Room room);
    void deleteContractByRoomId(long id);
    Contract getContractById(Long id);
    Contract getContractByRoomId(long id);
}
