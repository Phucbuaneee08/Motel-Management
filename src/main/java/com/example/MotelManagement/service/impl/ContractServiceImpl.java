package com.example.MotelManagement.service.impl;

import com.example.MotelManagement.entities.Contract;
import com.example.MotelManagement.entities.Renter;
import com.example.MotelManagement.entities.Room;
import com.example.MotelManagement.repository.ContractRepository;
import com.example.MotelManagement.repository.RenterRepository;
import com.example.MotelManagement.repository.RoomRepository;
import com.example.MotelManagement.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Service
public class ContractServiceImpl implements ContractService {
    RenterRepository renterRepository;
    ContractRepository contractRepository;
    RoomRepository roomRepository;
    public ContractServiceImpl(ContractRepository contractRepository){
        super();
        this.contractRepository=contractRepository;
    }

    @Override
    public Contract saveContract(Contract contract,Room room) {
        contract.setRoom(room);
        return contractRepository.save(contract);
    }

    @Override
    public Contract updateContract(Room room) {
        return null;
    }

    @Override
    public void deleteContractByRoomId(long id) {

//        List<Renter> listRenter = renterRepository.getRenterByRoomId(id);
////        System.out.println(listRenter.size());
////        for(Renter renter: listRenter) {
////            renterRepository.deleteById(renter.getId());
////        }
        contractRepository.deleteContractByRoomId(id);
    }

    @Override
    public Contract getContractById(Long id) {
        return null;
    }

    @Override
    public Contract getContractByRoomId(long id) {
        return contractRepository.getContractByRoomId(id);
    }
}
