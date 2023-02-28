package com.example.MotelManagement.repository;

import com.example.MotelManagement.entities.Motel;
import com.example.MotelManagement.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotelRepository extends JpaRepository<Motel,Long> {

}