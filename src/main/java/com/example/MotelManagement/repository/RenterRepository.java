package com.example.MotelManagement.repository;

import com.example.MotelManagement.entities.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Long> {
    List<Renter> getRenterByRoomId(long id);
}
