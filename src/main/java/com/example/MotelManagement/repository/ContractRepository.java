package com.example.MotelManagement.repository;

import com.example.MotelManagement.entities.Contract;
import com.example.MotelManagement.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {
    Contract getContractByRoomId(long id);
    void deleteContractByRoomId(long id);
}